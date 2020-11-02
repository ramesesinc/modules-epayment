package com.rameses.gov.epayment.models;


import com.rameses.rcp.annotations.*;

 
public class ErrorMsgModel {

    @Service("QueryService")
    def qrySvc;
    
    def errmsg;
    def entity;
    
    def po;
    def pmt;
    
    void init() {
        
        def m = [:];
        if( entity.laststate == 0 ) {
            m._schemaname = "eor_paymentorder";
        }
        else {
            m._schemaname = "eor_paymentorder_paid";            
        }
        m.findBy = [objid: entity.paymentrefid ];
        po = qrySvc.findFirst( m );
        
        if( entity.laststate != 0 ) {
            def n = [_schemaname: "eor"];
            n.findBy = [paymentrefid: entity.paymentrefid ];
            pmt = qrySvc.findFirst( n );
        }
    }
    
    def doClose() {
        return "_close";
    }
    
    
}