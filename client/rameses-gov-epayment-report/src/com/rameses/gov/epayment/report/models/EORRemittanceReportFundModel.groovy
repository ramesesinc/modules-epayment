package com.rameses.gov.epayment.report.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.reports.*;

class EORRemittanceReportFundModel extends ReportController {

    @Service("EORRemittanceReportFundService")
    def svc;
    
    @Binding
    def binding;

    def fundlist;
    def fund;

    String title = "Remittance Report By Fund";
    String reportpath =  "com/rameses/gov/epayment/report/remittance/"
    String reportName = reportpath + 'remittancereportfund.jasper' 
    
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
            new SubReport("ReportDItem", reportpath + "remittancereportfunditem.jasper"),
            new SubReport("ReportDSummary", reportpath + "remittancereportfundsummary.jasper"),
        ] as SubReport[];   
    }
    
     Map getParameters(){
        def params = [:]
        params.SUBTITLE = 'SUMMARY OF COLLECTION BY FUND'
        if ( fund ) {
            params.FUND_TITLE = '( ' + fund.title +' )' ;
        }
        return params;
     }
} 
