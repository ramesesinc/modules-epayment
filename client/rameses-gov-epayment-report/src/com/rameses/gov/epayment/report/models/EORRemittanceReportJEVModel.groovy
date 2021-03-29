package com.rameses.gov.epayment.report.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.reports.*;

class EORRemittanceReportJEVModel extends ReportController {

    @Binding
    def binding;

    @Service('EORRemittanceJevReportService')
    def svc;

    def title = 'Journal Entry Voucher Report';

    String reportPath = "com/rameses/gov/epayment/report/jev/";
    String reportName;
    
    def data = [:]; 
    def funds; 
    def fund; 
    def acctgroups; 
    def acctgroup; 

    def initReport() {
        reportName = reportPath + 'jev.jasper'; 
        
        def m = svc.initReport([ objid: entity.objid ]); 
        funds = m.funds; 
        acctgroups = m.acctgroups; 

        this.fund = (funds ? funds.first() : [:]);
        this.acctgroup = (acctgroups ? acctgroups.first() : [:]);
        return preview();
    } 
    
    SubReport[] getSubReports() { 
        return [ 
            new SubReport("ITEMS", reportPath + "jev_items.jasper"),
            new SubReport("SHARES", reportPath + "jev_shares.jasper"),
        ] as SubReport[]; 
    }

    def getReportData() {
        def m = [ objid: entity.objid ];
        m.fund = this.fund; 
        m.acctgroup = this.acctgroup; 
        
        def res = svc.getReport( m ); 
        data.clear(); 
        data.putAll( res ); 
        return data;
    }

    Map getParameters(){
        return data?.header; 
    }
} 
