package com.rameses.enterprise.treasury.models;

import com.rameses.seti2.models.CrudListModel;

class EORPaymentOrderListModel extends CrudListModel {

    public void initColumn( c ) { 
    }     
    
    public void beforeQuery( param ) {
        def _schemaname = selectedNode?._schemaname; 
        if ( _schemaname ) {
            param._schemaname = _schemaname; 
        }
    }
} 