package com.rameses.gov.epayment.views;

/**
 *
 * @author wflores
 */
public class EORRemittanceListlQueryPanel extends javax.swing.JPanel {

    /**
     * Creates new form EORRemittanceListlQueryPanel
     */
    public EORRemittanceListlQueryPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xLabel1 = new com.rameses.rcp.control.XLabel();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setLayout(new com.rameses.rcp.control.layout.XLayout());

        xLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 10));
        xLabel1.setText("Partner");
        add(xLabel1);

        xComboBox1.setExpression("#{item.objid} - #{item.name}");
        xComboBox1.setItems("partners");
        xComboBox1.setName("partner"); // NOI18N
        add(xComboBox1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XLabel xLabel1;
    // End of variables declaration//GEN-END:variables
}
