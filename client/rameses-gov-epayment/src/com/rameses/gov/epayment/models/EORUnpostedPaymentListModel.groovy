package com.rameses.gov.epayment.models;

import com.rameses.rcp.common.*;
import com.rameses.rcp.annotations.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class EORUnpostedPaymentListModel extends CrudListModel  {
    
    @Binding
    def binding;
    
    @Service("EPaymentResolverService")
    def resolverSvc;

    @FormTitle
    String title = "Unposted Payments List";
    
    def list;
    def mode = "init";
    int counter = 0;
    def errors = [];
    
    def listModel = [        
        fetchList: { o->
            return list;
        }
    ] as BasicListModel;
    
    void init() {
        list = resolverSvc.getList();
    }
    
    public def resolve() {
        mode = "processing";
        errors.clear();
        return "processing"; 
    }
    
    public def cancelProcess() {
        mode = "init";
        return "default";
    }
    
    def progress = [
        getTotalCount : {
           return list.size();
        },
        fetchList: { o->
            return list;
        },
        processItem: { o->
            try {
                resolverSvc.resolve(o);
            }
            catch(e) {
                errors << e.message;
            }
            binding.refresh('progressLabel');
        },
        onFinished: {
            mode = "finished";
            binding.refresh();
            def msg = "Processing complete";
            if( errors ) msg += " with errors "
            MsgBox.alert(msg);
        }
    ] as BatchProcessingModel;

    
}    
