package com.rameses.gov.epayment.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.CrudListModel;

public class EORListModel extends CrudListModel {

    def partner;
     
    def partnerList;
     
    void afterInit() {
        def m = [_schemaname: 'paymentpartner'];
        m.where = ["1=1"];
        partnerList = queryService.getList( m );
    }

    @PropertyChangeListener
    def listener = [
         "partner" : {
            reload();
        }
    ];
    
    def getCustomFilter() { 
        def m = [:]; 
        m.partnerid = ( partner?.objid ? partner.objid : '%'); 
        return ["partnerid LIKE :partnerid", m];
    } 
    
    public void initColumn( c ) { 
        def sname = c.name.toString(); 
        if ( sname.matches('receiptno|paymentrefid')) {
            c.width = c.maxWidth = 150; 
        }
        else if ( sname == 'receiptdate' ) {
            c.width = c.maxWidth = 100;
            c.alignment = 'center';
            c.type = 'date'; 
        }
        else if ( sname.matches('txntype|partnerid')) {
            c.width = c.maxWidth = 100;
        }
        else if ( sname == 'amount' ) {
            c.width = 100; 
            c.maxWidth = 120;
            c.type = 'decimal'; 
            c.alignment = 'right'; 
        }
        else if ( sname.matches('tracedate|txndate')) {
            c.width = c.maxWidth = 140; 
            c.type = 'date'; 
            c.outputFormat = 'yyyy-MM-dd HH:mm:ss'; 
        }

    }     
}
