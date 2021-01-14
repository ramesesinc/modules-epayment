package com.rameses.gov.epayment.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.CrudFormModel;
 
public class EORRemittanceInitialModel  extends CrudFormModel {
    
    @Service("OnlinePaymentResolverService")
    def onlineSvc;

    @Service("EORRemittanceService")
    def remittanceSvc;
    
    def partner;
    def partnerList;
    def selectedItem;
    
    void afterCreate() { 
        partnerList = remittanceSvc.getPaymentPartners(); 
        entity.state = 'DRAFT'; 
    } 
    
    void setPartner( o ) {
        this.partner = o; 
        listHandler.reload();
    }
    
    def listHandler = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o->
            if ( !partner ) return [];
            
            def m = [_schemaname: 'eor'];
            m.where = ["partnerid = :partnerid AND remittanceid IS NULL", [ partnerid: partner.objid ]];
            m.orderBy = "receiptdate"; 
            return queryService.getList( m ); 
        },
        afterSelectionChange: {
            entity.amount = listHandler.selectedValue.sum{( it.amount ? it.amount : 0.0 )} 
            entity.amount = ( entity.amount ? entity.amount : 0.0 ); 
            binding.notifyDepends("total"); 
        }, 
        onOpenItem: { o, name-> 
            if ( !o ) return null;
            return Inv.lookupOpener('eor:open', [ entity: o ]); 
        } 
    ] as DataListModel;
    
    def numformat = new java.text.DecimalFormat('#,##0.0000'); 
    def getFormattedAmount() {
        return numformat.format( entity.amount ? entity.amount : 0.0 ); 
    }
   
    def selectedPO;
    def resolveListHandler = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o->
            def m = [:]; 
            m.putAll( o ); 
            m._schemaname = 'eor_paymentorder';
            m.select = "objid, txndate, txntype, txntypename, paidby, paidbyaddress, amount, controlno"; 
            m.orderBy = "txndate DESC"; 
            m.node = [id: 'UNRESOLVED']; 
            return queryService.getList( m ); 
        }
    ] as PageListModel;

    public void resolve() { 
        if ( !resolveListHandler.selectedValue ) { 
            MsgBox.alert("Please select at least 1 item in the list"); 
            return; 
        } 

        def param = [ items: resolveListHandler.selectedValue ];
        param.callbackHandler = { o-> 
            resolveListHandler.doSearch(); 
        }
        Modal.show( "eor_paymentorder:resolve", param ); 
    }
    
    public void moveToCancelled() {
        if ( !resolveListHandler.selectedValue ) { 
            MsgBox.alert("Please select at least 1 item in the list"); 
            return; 
        } 

        def param = [ items: resolveListHandler.selectedValue ];
        param.callbackHandler = { o-> 
            resolveListHandler.doSearch(); 
        }
        Modal.show( "eor_paymentorder:cancel", param ); 
    }
    
    public def save() {
        if ( !listHandler.selectedValue ) 
            throw new Exception("Select at least one item from the unremitted receipts");
            
        def remamt = (entity.amount ? entity.amount : 0.0); 
        if ( remamt <= 0 )
            throw new Exception("Amount to remit must be greater than zero");

        def selamt = listHandler.selectedValue.sum{( it.amount ? it.amount : 0.0 )} 
        if ( !selamt ) selamt = 0.0; 
        if ( remamt != selamt )
            throw new Exception("Total amount from selection does not matched to the amount to be remitted");
            
        if (!MsgBox.confirm("You are about to create a remittance for the selected items. Proceed?")) return null;
        
        def arr = listHandler.selectedValue;
        entity.partnerid = partner.objid;
        entity.items = arr.collect{ [objid: it.objid ] }
        def res = remittanceSvc.create( entity );
        if ( res ) entity.putAll( res ); 
        
        binding.refresh(); 
        
        def op = Inv.lookupOpener("eor_remittance:open", [ entity: entity ]); 
        op.target = "topwindow"; 
        return op; 
    }
}