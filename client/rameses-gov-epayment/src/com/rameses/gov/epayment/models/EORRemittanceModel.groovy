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
public class EORRemittanceModel extends CrudFormModel {
    
    @Service('EORRemittanceService')
    def svc; 
    
    def numformat = new java.text.DecimalFormat('#,##0.0000'); 
    def getFormattedAmount() {
        return numformat.format(entity.amount ? entity.amount : 0.0); 
    }    
    
    def eorListHandler = [
        fetchList: { o->
            def m = [_schemaname: 'eor'];
            m.findBy = [remittanceid: entity.objid ];
            return queryService.getList( m );
        },
        onOpenItem: {o,col->
            def op = Inv.lookupOpener("eor:open", [entity: o ]);
            op.target = "popup";
            return op;
        }
    ] as BasicListModel;
    
    def selectedFund;
    def fundListHandler = [
        fetchList: { o->
            def m = [_schemaname: 'eor_remittance_fund'];
            m.findBy = [remittanceid: entity.objid ];
            return queryService.getList( m );
        }
    ] as BasicListModel;

    void validateFund() { 
        if ( !selectedFund ) throw new Exception('Please select fund'); 
        
        def m = [:];
        m.fields = [
            [caption: 'Validation Ref No', name:'refno', required:true],
            [caption: 'Validation Ref Date', name:'refdate', required:true, datatype:'date'],            
        ];
        if(entity.validation) {
            m.data = entity.validation;
        }
        m.handler = { o->
            svc.updateValidation([ objid: selectedFund.objid, validation: o ]); 
            fundListHandler.reload();
        };
        Modal.show( "dynamic:form", m, [title:"Validate Deposit Slip"] );                
    }
    
    def assignBankAccount() { 
        if ( !selectedFund ) throw new Exception('Please select fund'); 
        
        def p = [:]; 
        p.fundid = selectedFund.fund.objid; 
        p.onselect = { o-> 
            svc.updateBankAccount([ objid: selectedFund.objid, bankaccount: o ]); 
            fundListHandler.reload(); 
        }
        def op = Inv.lookupOpener('bankaccount:lookup', p );
        op.target = 'popup';
        return op;
        
    }
    
    void post() { 
        if ( MsgBox.confirm('You are about to post this transaction. Proceed?')) {
            def res = svc.post( entity ); 
            if ( res ) entity.putAll( res ); 
            
            binding.refresh();
        }
    }
    
    def listReports( inv ) {
        def popupMenu = new PopupMenuOpener();
        def list = Inv.lookupOpeners( inv.properties.category, [ entity: entity ]);
        list.each{ 
            popupMenu.add( it );
        }
        return popupMenu;
    } 
}