package com.rameses.gov.epayment.models;


import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;
import java.text.*;
 
/*******************************************************************************
* This class is used for Rental, Other Fees and Utilities
********************************************************************************/
public class EORRemittanceInitialModel  extends CrudFormModel {
    
    @Service("OnlinePaymentResolverService")
    def onlineSvc;

    @Service("EORRemittanceService")
    def remittanceSvc;
    
    def partner;
    def partnerList;
    def selectedItem;
    
    void afterCreate() {
        def m = [_schemaname: 'paymentpartner'];
        m.where = ["1=1"];
        partnerList = queryService.getList(m);
    }
    
    @PropertyChangeListener
    def listener = [
        "partner" : { o->
            listHandler.reload();
        } 
    ];
    
    def listHandler = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o->
            if( !partner ) return [];
            def m = [_schemaname: 'eor'];
            m.where = ["partnerid =:partnerid AND remittanceid IS NULL", [partnerid: partner.objid ]];
            m.orderBy = "tracedate";
            return queryService.getList(m);
        },
        afterSelectionChange: {
            entity.amount = listHandler.selectedValue.sum{ it.amount } 
            if ( entity.amount == null ) entity.amount = 0.0; 
            
            binding.notifyDepends("total"); 
        }, 
        onOpenItem: { o, name-> 
            if ( !o ) return null;
            return Inv.lookupOpener('eor:open', [ entity: o]); 
        }           
    ] as BasicListModel;
    
    def numformat = new java.text.DecimalFormat('#,##0.0000'); 
    def getFormattedAmount() {
        return numformat.format(entity.amount ? entity.amount : 0.0); 
    }
   
    def selectedPO;
    def resolveListHandler = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o->
            return [];
        }
    ] as BasicListModel;

    public void resolve() { 
        resolveListHandler.selectedValue?.each{ 
            onlineSvc.resolve( it ); 
        } 
    }
    
    public def save() {
        if( entity.amount <= 0 )
            throw new Exception("Please run compute amount first");
        if(entity.amount != listHandler.selectedValue.sum{it.amount})
            throw new Exception("Please run compute amount first");
            
        if(!MsgBox.confirm("You are about to create a remittance for the selected items. Proceed?")) return null;
        def arr = listHandler.selectedValue;
        entity.partnerid = partner.objid;
        entity.items = arr.collect{ [objid: it.objid ] };
        entity = remittanceSvc.create( entity );
        return Inv.lookupOpener("eor_remittance:open", [entity: entity ]);
    }
}