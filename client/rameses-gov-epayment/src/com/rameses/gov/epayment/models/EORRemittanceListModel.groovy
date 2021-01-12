package com.rameses.gov.epayment.models;

import com.rameses.rcp.annotations.*;
import com.rameses.seti2.models.CrudListModel;
 
public class EORRemittanceListModel extends CrudListModel {
    
    @Service('EORRemittanceService')
    def remSvc; 
    
    def partners = []; 
    def partner;

    void beforeInit() { 
        partners = remSvc.getPaymentPartners(); 
    } 
    
    void setPartner( o ) {
        this.partner = o; 
        updatePartnerQuery( o ); 
        search(); 
    }
    void updatePartnerQuery( o ) {
        if ( o?.objid ) {
            query.partnerid = o.objid; 
        }
        else {
            query.remove('partnerid'); 
        }
    }
    
    
    public void initColumn( c ) { 
        if ( c.name == 'controlno') {
            c.width = 140; 
            c.maxWidth = 180; 
        }
        else if ( c.name == 'controldate') {
            c.width = 100; 
            c.maxWidth = 100; 
            c.type = "date";
            c.alignment = "center";
            c.outputFormat = "yyyy-MM-dd";
        }
        else if ( c.name == 'amount') {
            c.width = 100; 
            c.maxWidth = 120; 
            c.type = "decimal";
            c.alignment = "right";
            c.outputFormat = "#,##0.00";
        }
        else if ( c.name.toString().matches('dtcreated|dtposted')) {
            c.width = 140; 
            c.maxWidth = 140; 
            c.type = "date";
            c.alignment = "center";
            c.outputFormat = "yyyy-MM-dd HH:mm:ss";
        }
        else if ( c.name == 'state') {
            c.maxWidth = 100;
        }
    }   
}