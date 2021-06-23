/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author galih
 */
public class tampilan extends javax.swing.JFrame {
    private DefaultTableModel table_data;
    
    String newfolder;
    Main main = new Main();
    public tampilan() {   
        initComponents();
        this.TampilData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newFolder_btn = new javax.swing.JButton();
        upload_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        data_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newFolder_btn.setText("New Folder");
        newFolder_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFolder_btnActionPerformed(evt);
            }
        });

        upload_btn.setText("Upload File");
        upload_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_btnActionPerformed(evt);
            }
        });

        data_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(data_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newFolder_btn)
                        .addGap(42, 42, 42)
                        .addComponent(upload_btn)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFolder_btn)
                    .addComponent(upload_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static Object[] add(Object[] arr, Object... elements){
        Object[] tempArr = new Object[arr.length+elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        
        for (int i=0; i <elements.length; i++){
            tempArr[arr.length+i] = elements[i];
        }
        return tempArr;
    }
    
    public void TampilData(){
        table_data = new DefaultTableModel();
        table_data.addColumn("Name");
        table_data.addColumn("Type");
        data_table.setModel(table_data);
        
        table_data.addRow(new Object[]{
            
        });
        
        try {
            List<com.google.api.services.drive.model.File> result = main.retrieveAllFiles();
            String datas[][] = new String[result.size()][2];
            int i = 0;
            for (com.google.api.services.drive.model.File temp : result) {
                datas[i][0] = temp.getName();
                datas[i][1] = temp.getMimeType();
                i++;
            }
            
//            for (int j = 0; j < result.size(); j++){
//                System.out.println(datas[j][0]);
//                System.out.println(datas[j][1]);
//            }
            
            for (int row = 0; row < result.size(); row++) {
                    Object[] nye = {};
                    for (int col = 0; col < 2; col++){
                        nye = add(nye, datas[row][col]);   
                    }
                table_data.addRow(nye);
            }
        } catch (IOException ex) {
            Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void newFolder_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFolder_btnActionPerformed

        newfolder = JOptionPane.showInputDialog("Isikan nama folder", null);
        if (newfolder == null) {
            System.out.println("Canceled!");
        } else {
            try {
                main.newFolder(newfolder);
            } catch (IOException ex) {
                Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_newFolder_btnActionPerformed

    private void upload_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_btnActionPerformed
      FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
      dialog.setMode(FileDialog.LOAD);
      dialog.setVisible(true);
      String file = dialog.getFile();
      Path p1 = Paths.get(file);
        try {
            String mimeType = Files.probeContentType(p1);
            System.out.println(mimeType);
            main.uploadFile(dialog.getDirectory(), file, mimeType);
            
        } catch (IOException ex) {
            Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_upload_btnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable data_table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newFolder_btn;
    private javax.swing.JButton upload_btn;
    // End of variables declaration//GEN-END:variables

}
