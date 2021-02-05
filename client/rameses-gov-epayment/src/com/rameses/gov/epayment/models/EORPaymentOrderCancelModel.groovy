package com.rameses.gov.epayment.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.rcp.framework.ClientContext; 
 
public class EORPaymentOrderCancelModel {

    @Binding 
    def binding;
    
    @Service("EORPaymentResolverService")
    def resolverSvc;

    def items; 
    def callbackHandler;
    
    int runlevel; 
    
    void init() { 
        runlevel = 0; 
    } 
    
    def logHandler = new TextWriter(); 

    void doStart() {
        runlevel = 1; 
        ClientContext.currentContext.taskManager.addTask({
            startProcess(); 
        }); 
    }
    
    void doStop() { 
        runlevel = 2; 
        ClientContext.currentContext.taskManager.addTask({
            stopProcess(); 
        }); 
    }
    
    @Close
    def doClose() {
        if ( runlevel > 0 ) {
            MsgBox.alert("Stop the process first before closing the window"); 
            return false; 
        }
        return true; 
    }
    
    private void startProcess() {
        logHandler.clear(); 
        logHandler.writeln("Starting... ");

        items.each{ po-> 
            try {
                processItem( po ); 
            } 
            catch(e) { 
                logHandler.writeln("   Error: "+ e.message); 
                e.printStackTrace(); 
            }
        }
        
        logHandler.writeln("\nDone. ");
        
        runlevel = 0; 
        binding.refresh(); 
        
        if ( callbackHandler ) {
            callbackHandler(); 
        }
    }
    
    private void stopProcess() { 
        logHandler.writeln("Stopping..."); 
    }
    
    private void processItem( po ) {
        logHandler.writeln("\n[ "+ po.objid +" ] move to cancelled..."); 
        def cc = resolverSvc.moveToCancelled( po ); 
        if ( cc?.objid ) {
            logHandler.writeln("   Status: OK"); 
        }
        else {
            logHandler.writeln("   Status: "+ cc?.msg); 
        }
    }
}