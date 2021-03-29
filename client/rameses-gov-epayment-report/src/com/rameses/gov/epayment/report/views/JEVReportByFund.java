package com.rameses.gov.epayment.report.views;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author  wflores
 */
@Template(FormPage.class)
public class JEVReportByFund extends javax.swing.JPanel {
    
    public JEVReportByFund() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xComboBox2 = new com.rameses.rcp.control.XComboBox();
        jLabel1 = new javax.swing.JLabel();
        xButton1 = new com.rameses.rcp.control.XButton();
        xReportPanel1 = new com.rameses.osiris2.reports.ui.XReportPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanel2.setLayout(new com.rameses.rcp.control.layout.XLayout());

        xLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 5));
        xLabel1.setText("Fund :");
        jPanel2.add(xLabel1);

        xComboBox1.setExpression("#{item.title}");
        xComboBox1.setImmediate(true);
        xComboBox1.setItems("funds");
        xComboBox1.setName("fund"); // NOI18N
        xComboBox1.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel2.add(xComboBox1);

        xLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 5));
        xLabel2.setText("Account Group : ");
        jPanel2.add(xLabel2);

        xComboBox2.setExpression("#{item.title}");
        xComboBox2.setImmediate(true);
        xComboBox2.setItems("acctgroups");
        xComboBox2.setName("acctgroup"); // NOI18N
        jPanel2.add(xComboBox2);

        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 10));
        jPanel2.add(jLabel1);

        xButton1.setMnemonic('R');
        xButton1.setText("Rebuild");
        xButton1.setName("preview"); // NOI18N
        jPanel2.add(xButton1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        xReportPanel1.setDepends(new String[] {"fund"});
        xReportPanel1.setName("report"); // NOI18N

        org.jdesktop.layout.GroupLayout xReportPanel1Layout = new org.jdesktop.layout.GroupLayout(xReportPanel1);
        xReportPanel1.setLayout(xReportPanel1Layout);
        xReportPanel1Layout.setHorizontalGroup(
            xReportPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 604, Short.MAX_VALUE)
        );
        xReportPanel1Layout.setVerticalGroup(
            xReportPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 334, Short.MAX_VALUE)
        );

        add(xReportPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XComboBox xComboBox2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.osiris2.reports.ui.XReportPanel xReportPanel1;
    // End of variables declaration//GEN-END:variables
    
}
