/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.validation;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AdministratorJa
 */
public class DatabaseValidationUI extends javax.swing.JFrame {

    /**
     * Creates new form DatabaseValidationUI
     * @param dailyWO
     * @param report
     */
    public DatabaseValidationUI(WOData[] dailyWO, WOData[] report) {
        this.dailyWO = dailyWO;
        this.report = report;
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        DailyWOTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ReportTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        ValidationTable = new javax.swing.JTable();
        DailyWOPanel = new javax.swing.JPanel();
        ChooseDailyWOButton = new javax.swing.JButton();
        DailyWOTextField = new javax.swing.JTextField();
        ReportPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        ReportTextField = new javax.swing.JTextField();
        FunctionsPanel = new javax.swing.JPanel();
        ScanDailyWOButton = new javax.swing.JButton();
        ScanReportButton = new javax.swing.JButton();
        ValidateDatabasesButton = new javax.swing.JButton();
        StatusLabel = new javax.swing.JLabel();
        MainMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.0\\null"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        DailyWOTable.setAutoCreateRowSorter(true);
        DailyWOTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numer klienta", "Min godz", "Max godz", "Adres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DailyWOTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(DailyWOTable);
        if (DailyWOTable.getColumnModel().getColumnCount() > 0) {
            DailyWOTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            DailyWOTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            DailyWOTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            DailyWOTable.getColumnModel().getColumn(3).setPreferredWidth(600);
        }

        jTabbedPane1.addTab("Daily WO", jScrollPane1);

        ReportTable.setAutoCreateRowSorter(true);
        ReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numer klienta", "Min godz", "Max godz", "Adres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ReportTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(ReportTable);
        if (ReportTable.getColumnModel().getColumnCount() > 0) {
            ReportTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            ReportTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            ReportTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            ReportTable.getColumnModel().getColumn(3).setPreferredWidth(600);
        }

        jTabbedPane1.addTab("Raport", jScrollPane2);

        ValidationTable.setAutoCreateRowSorter(true);
        ValidationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, ""},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numer klienta", "Min godz", "Max godz", "Adres DWO", "Numer klienta", "Min godz", "Max godz", "Adres Raport", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ValidationTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(ValidationTable);
        if (ValidationTable.getColumnModel().getColumnCount() > 0) {
            ValidationTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            ValidationTable.getColumnModel().getColumn(0).setCellRenderer(null);
            ValidationTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            ValidationTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            ValidationTable.getColumnModel().getColumn(3).setPreferredWidth(270);
            ValidationTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            ValidationTable.getColumnModel().getColumn(5).setPreferredWidth(60);
            ValidationTable.getColumnModel().getColumn(6).setPreferredWidth(60);
            ValidationTable.getColumnModel().getColumn(7).setPreferredWidth(270);
            ValidationTable.getColumnModel().getColumn(8).setPreferredWidth(170);
        }

        jTabbedPane1.addTab("Zestawienie", jScrollPane3);

        ChooseDailyWOButton.setText("Wybierz Daily WO");
        ChooseDailyWOButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseDailyWOButtonActionPerformed(evt);
            }
        });

        DailyWOTextField.setEditable(false);
        DailyWOTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout DailyWOPanelLayout = new javax.swing.GroupLayout(DailyWOPanel);
        DailyWOPanel.setLayout(DailyWOPanelLayout);
        DailyWOPanelLayout.setHorizontalGroup(
            DailyWOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DailyWOPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ChooseDailyWOButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DailyWOTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DailyWOPanelLayout.setVerticalGroup(
            DailyWOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DailyWOPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DailyWOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChooseDailyWOButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DailyWOTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setText("Wybierz raport");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ReportTextField.setEditable(false);
        ReportTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout ReportPanelLayout = new javax.swing.GroupLayout(ReportPanel);
        ReportPanel.setLayout(ReportPanelLayout);
        ReportPanelLayout.setHorizontalGroup(
            ReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ReportPanelLayout.setVerticalGroup(
            ReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ScanDailyWOButton.setText("Skanuj Daily WO");
        ScanDailyWOButton.setEnabled(false);
        ScanDailyWOButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanDailyWOButtonActionPerformed(evt);
            }
        });

        ScanReportButton.setText("Skanuj raport");
        ScanReportButton.setEnabled(false);
        ScanReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanReportButtonActionPerformed(evt);
            }
        });

        ValidateDatabasesButton.setText("Porównaj bazy danych");
        ValidateDatabasesButton.setEnabled(false);
        ValidateDatabasesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidateDatabasesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FunctionsPanelLayout = new javax.swing.GroupLayout(FunctionsPanel);
        FunctionsPanel.setLayout(FunctionsPanelLayout);
        FunctionsPanelLayout.setHorizontalGroup(
            FunctionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FunctionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScanDailyWOButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScanReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ValidateDatabasesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        FunctionsPanelLayout.setVerticalGroup(
            FunctionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FunctionsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FunctionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScanDailyWOButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScanReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ValidateDatabasesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenu1.setText("Plik");

        jMenuItem1.setText("Zamknij");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        MainMenu.add(jMenu1);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DailyWOPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FunctionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ReportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DailyWOPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FunctionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("tab1");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChooseDailyWOButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseDailyWOButtonActionPerformed
        GetFile("dailywo");
    }//GEN-LAST:event_ChooseDailyWOButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GetFile("report");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ScanDailyWOButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanDailyWOButtonActionPerformed
        if (dailyWOFile != null) dailyWO = DatabaseValidation.ScanDatabase(dailyWOFile.getPath(), "dailywo");
        FillTable(DailyWOTable, dailyWO);
    }//GEN-LAST:event_ScanDailyWOButtonActionPerformed

    private void ScanReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanReportButtonActionPerformed
        if (reportFile != null) report = DatabaseValidation.ScanDatabase(reportFile.getPath(), "report");
        FillTable(ReportTable, report);
    }//GEN-LAST:event_ScanReportButtonActionPerformed

    private void ValidateDatabasesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidateDatabasesButtonActionPerformed
        if ((dailyWO != null) && (report != null))
        {
            comparator = new Comparator();
            ValidationTable.setModel(comparator.CompareDatabases(dailyWO, report, ValidationTable));
            SetStatus(comparator.GetOverallStatus());
        }
    }//GEN-LAST:event_ValidateDatabasesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private File dailyWOFile;
    private File reportFile;
    private WOData[] dailyWO;
    private WOData[] report;
    private Comparator comparator;
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatabaseValidationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseValidationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseValidationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseValidationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new DatabaseValidationUI().setVisible(true);
            }
        });
    }
    
    private void GetFile(String fileType)
    {
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            if ("dailywo".equals(fileType))
            {
                dailyWOFile = jFileChooser1.getSelectedFile();
                DailyWOTextField.setText(dailyWOFile.getName());
                ScanDailyWOButton.setEnabled(true);
                if (ScanDailyWOButton.isEnabled() == true && ScanReportButton.isEnabled() == true) ValidateDatabasesButton.setEnabled(true);
            }
            if ("report".equals(fileType))
            {
                reportFile = jFileChooser1.getSelectedFile();
                ReportTextField.setText(reportFile.getName());
                ScanReportButton.setEnabled(true);
                if (ScanDailyWOButton.isEnabled() == true && ScanReportButton.isEnabled() == true) ValidateDatabasesButton.setEnabled(true);
            }
        }
    }
    
    private void FillTable(JTable table, WOData[] database)
    {
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(database.length);
        for (int i=0;i<database.length;i++)
        {
            model.setValueAt(database[i].getClientNumber(), i, 0);
            model.setValueAt(database[i].getMinTime(), i, 1);
            model.setValueAt(database[i].getMaxTime(), i, 2);
            model.setValueAt(database[i].getClientAddress(), i, 3);
        }
        table.setModel(model);
        SetStatus("Zeskanowano " + database.length + " wierszy!");
    }
    
    private void SetStatus(String message)
    {
        StatusLabel.setText(message);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChooseDailyWOButton;
    private javax.swing.JPanel DailyWOPanel;
    private javax.swing.JTable DailyWOTable;
    private javax.swing.JTextField DailyWOTextField;
    private javax.swing.JPanel FunctionsPanel;
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JPanel ReportPanel;
    private javax.swing.JTable ReportTable;
    private javax.swing.JTextField ReportTextField;
    private javax.swing.JButton ScanDailyWOButton;
    private javax.swing.JButton ScanReportButton;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JButton ValidateDatabasesButton;
    private javax.swing.JTable ValidationTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
