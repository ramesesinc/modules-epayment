package com.rameses.gov.epayment.report.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.reports.*;

class EORRemittanceReportFundModel extends ReportController {

    @Service("EORRemittanceReportByItemAccountService")
    def svc;
    
    @Binding
    def binding;

    def fundlist;
    def fund;

    String title = "Remittance Report By Revenue Item";
    String reportpath =  "com/rameses/gov/epayment/report/remittance/"
    String reportName = reportpath + 'reportbyrevenueitem.jasper' 
    
    def initReport() { 
        fundlist = svc.getFunds([ remittanceid: entity.objid ]); 
        return preview(); 
    } 
    
    void setFund( fund ) {
        this.fund = fund; 
        
        preview(); 
        binding.refresh();
    }
    
    def getReportData() { 
        def param = [:]; 
        param.putAll( entity ); 
        param.fund = fund; 
        param.remittanceid = entity.objid; 
        return svc.getReport( param ); 
    }
    
    SubReport[] getSubReports() {
        return [ 
            new SubReport("ReportSummary", reportpath + "reportbyrevenueitemsummary.jasper"),
            new SubReport("BrgyShareSummary", reportpath + "reportbyrevenueitemsummary_share.jasper")
        ] as SubReport[];   
    }
    
     Map getParameters(){
        def params = [:]
        params.SUBTITLE = 'SUMMARY OF COLLECTION BY ITEM ACCOUNT';
        if (fund) {
            params.FUND_TITLE = '( ' + fund.title + ' )' ;
        }
        return params;
     }
} 
