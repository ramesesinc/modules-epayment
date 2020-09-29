package com.rameses.gov.epayment.models;


import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;
 
public class PaymentPartnerListModel extends CrudListModel  {
    
    @Service("EPaymentPartnerService")
    def partnerSvc;
    
    void syncCloud() {
        partnerSvc.syncPaymentPartner();
        reload();
        MsgBox.alert('Sync completed!');  
    }

}