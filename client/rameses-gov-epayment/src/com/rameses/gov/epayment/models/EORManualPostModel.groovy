package com.rameses.gov.epayment.models;


import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;
import java.text.*;
 
/*******************************************************************************
* This is for executing payment manually if payment partner fails to send
* reply to the cloud
********************************************************************************/
public class EORManualPostModel  {

    @Service("EORManualPostService")
    def svc;
    
    def entity;
    def mode;
    boolean editable;
    def txntypes;
    
    void init() {
        txntypes = svc.getTxnTypes();
    }
    
    void create() {
        init();
        entity = [:];
        mode = "create"
        editable = true;
    }
    
    void open() {
        init();
        entity = svc.open([objid: entity.objid]);
        mode = "open";
    }
    
    def submit() {
        if(!MsgBox.confirm("You are about to submit this transaction. Please confirm")) return null;
        def stat = svc.post( entity );
        if( stat.status == "error") {
             Modal.show( "eor_error:view",[ entity: stat ]);
        }
        else {
            MsgBox.alert("Transaction successful");
        }
        return "_close";
    }
    
}