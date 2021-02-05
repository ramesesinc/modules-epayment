/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.epayment.views;

import com.rameses.osiris2.common.BasicListModel;
import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.common.ListItem;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author Elmo Nazareno
 */
@Template(FormPage.class)
public class EORRemittanceInitialPage extends javax.swing.JPanel {

    /**
     * Creates new form EORRemittanceInitialPage
     */
    public EORRemittanceInitialPage() {
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

        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xDateField1 = new com.rameses.rcp.control.XDateField();
        xTabbedPane1 = new com.rameses.rcp.control.XTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        xLabel2 = new com.rameses.rcp.control.XLabel();
        xActionTextField1 = new com.rameses.rcp.control.XActionTextField();
        jPanel7 = new javax.swing.JPanel();
        xButton2 = new com.rameses.rcp.control.XButton();
        xButton1 = new com.rameses.rcp.control.XButton();
        xButton3 = new com.rameses.rcp.control.XButton();
        xDataTable3 = new com.rameses.rcp.control.XDataTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnMoveFirst = new com.rameses.rcp.control.XButton();
        btnMovePrev = new com.rameses.rcp.control.XButton();
        btnMoveNext = new com.rameses.rcp.control.XButton();
        btnMoveLast = new com.rameses.rcp.control.XButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 0), new java.awt.Dimension(35, 0), new java.awt.Dimension(35, 32767));
        lblRecordCount = new com.rameses.rcp.control.XLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        lblPageCount = new com.rameses.rcp.control.XLabel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();

        xFormPanel1.setCaption("Enter Date");
        xFormPanel1.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);
        xFormPanel1.setCaptionWidth(120);
        xFormPanel1.setCellspacing(5);

        xComboBox1.setCaption("Partner");
        xComboBox1.setExpression("#{ item.objid } - #{item.name}");
        xComboBox1.setItems("partnerList");
        xComboBox1.setName("partner"); // NOI18N
        xComboBox1.setEmptyText("- Select a Partner -");
        xComboBox1.setPreferredSize(new java.awt.Dimension(0, 20));
        xComboBox1.setRequired(true);
        xFormPanel1.add(xComboBox1);

        xDateField1.setCaption("Remittance Date");
        xDateField1.setName("entity.controldate"); // NOI18N
        xDateField1.setRequired(true);
        xFormPanel1.add(xDateField1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setLayout(new java.awt.BorderLayout());

        xDataTable1.setHandler("listHandler");
        xDataTable1.setName("selectedItem"); // NOI18N
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "receiptno"}
                , new Object[]{"caption", "Receipt No"}
                , new Object[]{"width", 150}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 150}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "receiptdate"}
                , new Object[]{"caption", "Receipt Date"}
                , new Object[]{"width", 120}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 120}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"alignment", "CENTER"}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DateColumnHandler(null, "yyyy-MM-dd", null)}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "partnerid"}
                , new Object[]{"caption", "Partner"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 120}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "txntype"}
                , new Object[]{"caption", "Txn Type"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 120}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "paidby"}
                , new Object[]{"caption", "Paid By"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "paidbyaddress"}
                , new Object[]{"caption", "Payer Address"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "amount"}
                , new Object[]{"caption", "Amount"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 120}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"alignment", "RIGHT"}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DecimalColumnHandler("#,##0.00", -1.0, -1.0, false, 2)}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "paymentrefid"}
                , new Object[]{"caption", "PO No."}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 150}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "traceid"}
                , new Object[]{"caption", "Trace No"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "tracedate"}
                , new Object[]{"caption", "Trace Date"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 140}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"alignment", "CENTER"}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DateColumnHandler(null, "yyyy-MM-dd HH:mm:ss", null)}
            })
        });
        jPanel1.add(xDataTable1, java.awt.BorderLayout.CENTER);

        xTabbedPane1.addTab("   Unremitted Receipts          ", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 5, 5));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 28));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new com.rameses.rcp.control.layout.XLayout());

        xLabel2.setCaption("Search");
        xLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 10));
        xLabel2.setFontStyle("font-weight: bold;");
        xLabel2.setForeground(new java.awt.Color(80, 80, 80));
        xLabel2.setText("Search");
        jPanel6.add(xLabel2);

        xActionTextField1.setActionName("resolveListHandler.doSearch");
        xActionTextField1.setName("resolveListHandler.searchtext"); // NOI18N
        xActionTextField1.setFocusKeyStroke("F3");
        xActionTextField1.setMaxLength(50);
        xActionTextField1.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel6.add(xActionTextField1);

        jPanel5.add(jPanel6, java.awt.BorderLayout.EAST);

        com.rameses.rcp.control.layout.XLayout xLayout2 = new com.rameses.rcp.control.layout.XLayout();
        xLayout2.setSpacing(5);
        jPanel7.setLayout(xLayout2);

        xButton2.setDepends(new String[] {"selectedPO"});
        xButton2.setMnemonic('r');
        xButton2.setName("resolveListHandler.reload"); // NOI18N
        xButton2.setImmediate(true);
        xButton2.setText("Refresh");
        jPanel7.add(xButton2);

        xButton1.setDepends(new String[] {"selectedPO"});
        xButton1.setMnemonic('l');
        xButton1.setName("resolve"); // NOI18N
        xButton1.setImmediate(true);
        xButton1.setText("Resolve");
        jPanel7.add(xButton1);

        xButton3.setDepends(new String[] {"selectedPO"});
        xButton3.setMnemonic('v');
        xButton3.setName("moveToCancelled"); // NOI18N
        xButton3.setImmediate(true);
        xButton3.setText("Move To Cancelled");
        jPanel7.add(xButton3);

        jPanel5.add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel2.add(jPanel5, java.awt.BorderLayout.NORTH);

        xDataTable3.setHandler("resolveListHandler");
        xDataTable3.setName("selectedPO"); // NOI18N
        xDataTable3.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "objid"}
                , new Object[]{"caption", "Payment Order No."}
                , new Object[]{"width", 140}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 150}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "txndate"}
                , new Object[]{"caption", "Txn Date"}
                , new Object[]{"width", 140}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 140}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DateColumnHandler(null, "yyyy-MM-dd HH:mm:ss", null)}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "txntypename"}
                , new Object[]{"caption", "Txn Type"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 150}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "amount"}
                , new Object[]{"caption", "Amount"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 100}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.DecimalColumnHandler("#,##0.00", -1.0, -1.0, false, 2)}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "paidby"}
                , new Object[]{"caption", "Paid By"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "paidbyaddress"}
                , new Object[]{"caption", "PaidBy Address"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "controlno"}
                , new Object[]{"caption", "ControlNo"}
                , new Object[]{"width", 140}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 140}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.NONE}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            })
        });
        jPanel2.add(xDataTable3, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jPanel3.setLayout(new com.rameses.rcp.control.layout.XLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 20));
        com.rameses.rcp.control.layout.XLayout xLayout1 = new com.rameses.rcp.control.layout.XLayout();
        xLayout1.setSpacing(1);
        jPanel4.setLayout(xLayout1);

        jToolBar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnMoveFirst.setName("resolveListHandler.moveFirstPage"); // NOI18N
        btnMoveFirst.setAutoRefresh(false);
        btnMoveFirst.setFocusable(false);
        btnMoveFirst.setIconResource("images/navbar/first.png");
        btnMoveFirst.setImmediate(true);
        jToolBar2.add(btnMoveFirst);

        btnMovePrev.setName("resolveListHandler.moveBackPage"); // NOI18N
        btnMovePrev.setAutoRefresh(false);
        btnMovePrev.setFocusable(false);
        btnMovePrev.setIconResource("images/navbar/previous.png");
        btnMovePrev.setImmediate(true);
        jToolBar2.add(btnMovePrev);

        btnMoveNext.setName("resolveListHandler.moveNextPage"); // NOI18N
        btnMoveNext.setAutoRefresh(false);
        btnMoveNext.setFocusable(false);
        btnMoveNext.setIconResource("images/navbar/next.png");
        btnMoveNext.setImmediate(true);
        jToolBar2.add(btnMoveNext);

        btnMoveLast.setName("resolveListHandler.moveLastPage"); // NOI18N
        btnMoveLast.setAutoRefresh(false);
        btnMoveLast.setFocusable(false);
        btnMoveLast.setIconResource("images/navbar/last.png");
        btnMoveLast.setImmediate(true);
        jToolBar2.add(btnMoveLast);
        jToolBar2.add(filler1);

        jPanel4.add(jToolBar2);

        lblRecordCount.setDepends(new String[] {"selectedPO"});
        lblRecordCount.setExpression("#{resolveListHandler.recordCountInfo}");
        lblRecordCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        lblRecordCount.setUseHtml(true);
        jPanel4.add(lblRecordCount);
        jPanel4.add(filler2);

        lblPageCount.setDepends(new String[] {"selectedPO"});
        lblPageCount.setExpression("#{resolveListHandler.pageCountInfo}");
        lblPageCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        lblPageCount.setUseHtml(true);
        jPanel4.add(lblPageCount);

        jPanel3.add(jPanel4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.SOUTH);

        xTabbedPane1.addTab("   Unresolved Payment Orders          ", jPanel2);

        xFormPanel2.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);
        xFormPanel2.setCellspacing(5);

        xLabel1.setCaption("Amount");
        xLabel1.setDepends(new String[] {"total"});
        xLabel1.setExpression("#{formattedAmount}");
        xLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180)));
        xLabel1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 24));
        xFormPanel2.add(xLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addComponent(xTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XButton btnMoveFirst;
    private com.rameses.rcp.control.XButton btnMoveLast;
    private com.rameses.rcp.control.XButton btnMoveNext;
    private com.rameses.rcp.control.XButton btnMovePrev;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToolBar jToolBar2;
    private com.rameses.rcp.control.XLabel lblPageCount;
    private com.rameses.rcp.control.XLabel lblRecordCount;
    private com.rameses.rcp.control.XActionTextField xActionTextField1;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XButton xButton3;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XDataTable xDataTable3;
    private com.rameses.rcp.control.XDateField xDateField1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XLabel xLabel2;
    private com.rameses.rcp.control.XTabbedPane xTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
