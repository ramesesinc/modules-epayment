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
public class EORErrorListModel extends CrudListModel  {
    
    @Service("EPaymentResolverService")
    def epmtResolver;
    
    void resolve() {
        if(!selectedItem) throw new Exception("Please select an item ");
        epmtResolver.resolveError( selectedItem );
        reload();
    }
    
    def viewError() {
        if(!selectedItem) throw new Exception("Please select an item ");
        return Inv.lookupOpener( "eor_error:view", [entity: selectedItem ]);
    }
    
    def open() {
        if(!selectedItem) throw new Exception("Please select an item ");
        return viewError();
        //return Inv.lookupOpener( "eor_error:view", [errmsg: selectedItem.errdetail ]);
    }

}