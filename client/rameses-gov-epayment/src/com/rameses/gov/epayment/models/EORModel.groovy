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
public class EORModel extends CrudFormModel  {

    @Service("EOREmailService")
    def eorEmailSvc;
    
    def preview() {
        return Inv.lookupOpener("eor:printout", [query: [ objid: entity.objid ]] );
    }
    
    def resend() {
        if(!MsgBox.confirm("You are about to resend this email. Proceed?")) return null;
        eorEmailSvc.resend( [objid: entity.objid ] );
        MsgBox.alert("Email sent");
    }
    
}