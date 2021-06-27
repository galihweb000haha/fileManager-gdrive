/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradleproject1;


import java.awt.FileDialog;
import java.awt.Frame;


import java.io.IOException;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author galih
 */
public class tampilan extends javax.swing.JFrame {
    private DefaultTableModel table_data;
    ArrayList url = new ArrayList();
   
    String newfolder;
    String ID;
    Main main = new Main();
    public tampilan() {   
        initComponents();
        this.TampilData();
        url.add("root");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newFolder_btn = new javax.swing.JButton();
        upload_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        data_table = new javax.swing.JTable();
        delete_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dowload_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        treeFolder = new javax.swing.JTree();
        cari_btn = new javax.swing.JButton();
        keyword_input = new javax.swing.JTextField();
        open_btn = new javax.swing.JButton();

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
        data_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(data_table);

        delete_btn.setText("Delete File");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jButton1.setText("Open File");

        dowload_btn.setText("Download");
        dowload_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dowload_btnActionPerformed(evt);
            }
        });

        treeFolder.setModel(new DefaultTreeModel(getStrukturFamily("root", "")));
        treeFolder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeFolderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(treeFolder);

        cari_btn.setText("Cari");
        cari_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_btnActionPerformed(evt);
            }
        });

        open_btn.setText("Open");
        open_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(open_btn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newFolder_btn)
                                .addGap(42, 42, 42)
                                .addComponent(upload_btn)
                                .addGap(50, 50, 50)
                                .addComponent(delete_btn)
                                .addGap(45, 45, 45)
                                .addComponent(jButton1)
                                .addGap(41, 41, 41)
                                .addComponent(dowload_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(keyword_input, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cari_btn)))
                        .addGap(98, 98, 98))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFolder_btn)
                    .addComponent(upload_btn)
                    .addComponent(delete_btn)
                    .addComponent(jButton1)
                    .addComponent(dowload_btn)
                    .addComponent(cari_btn)
                    .addComponent(keyword_input, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(open_btn))
                .addContainerGap(89, Short.MAX_VALUE))
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
        table_data.addColumn("ID");
        table_data.addColumn("Name");
        table_data.addColumn("Type");
        data_table.setModel(table_data);
        try {
            List<com.google.api.services.drive.model.File> result;
            if(url.size() == 0){
                result = main.getFiles("root");
            } else {
                result = main.getFiles(url.get(url.size()-1).toString());
            }
            
            String datas[][] = new String[result.size()][3];
            int i = 0;
            for (com.google.api.services.drive.model.File temp : result) {
                if(temp.getMimeType() != "application/vnd.google-apps.folder") {
                    datas[i][0] = temp.getId();
                    datas[i][1] = temp.getName();
                    datas[i][2] = temp.getMimeType();
                    i++;
                    System.out.println(temp.getMimeType());
                }else{
                    System.out.println("ok");
                }
            }
            table_data.setRowCount(0);
            for (int row = 0; row < result.size(); row++) {
                    Object[] nye = {};
                    for (int col = 0; col < 3; col++){
                        nye = add(nye, datas[row][col]);   
                    }
                table_data.addRow(nye);
            }
        } catch (IOException ex) {
            Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
        }
       
//        try {
//            List<com.google.api.services.drive.model.File> result = main.retrieveAllFiles();
//            String datas[][] = new String[result.size()][3];
//            int i = 0;
//            for (com.google.api.services.drive.model.File temp : result) {
//                datas[i][0] = temp.getId();
//                datas[i][1] = temp.getName();
//                datas[i][2] = temp.getMimeType();
//                i++;
//            }
//           
//            
//            for (int row = 0; row < result.size(); row++) {
//                    Object[] nye = {};
//                    for (int col = 0; col < 3; col++){
//                        nye = add(nye, datas[row][col]);   
//                    }
//                table_data.addRow(nye);
//            }
//            
//        } catch (IOException ex) {
//            Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
        TampilData();
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
        
        TampilData();
    }//GEN-LAST:event_upload_btnActionPerformed

    private void data_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_tableMouseClicked
        int baris = data_table.getSelectedRow();
        ID = data_table.getValueAt(baris, 0).toString();
        
    }//GEN-LAST:event_data_tableMouseClicked

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if (ID == null) {
            System.out.println("Pilih ID dulu bos");
        } else {
            try {
                main.deleteFile(ID);
            } catch (IOException ex) {
                Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        TampilData();
    }//GEN-LAST:event_delete_btnActionPerformed

    private void dowload_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dowload_btnActionPerformed
        if (ID == null) {
            System.out.println("Pilih ID dulu bos");
        } else {
            try {
                main.downloadFile(ID);
            } catch (IOException ex) {
                Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_dowload_btnActionPerformed

    public DefaultMutableTreeNode getStrukturFamily(String id, String name){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("../"+name);
        try {
            
            List<com.google.api.services.drive.model.File> result = main.getDir(id);
            
            for (com.google.api.services.drive.model.File temp : result) {
                    root.add(new DefaultMutableTreeNode(temp.getName() + "#"+ temp.getId()));
            }
 
        } catch (IOException ex) {
            Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return root;
        
    }
    private void cari_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_btnActionPerformed
        String keyword = keyword_input.getText();
        try {
            
            List<com.google.api.services.drive.model.File> result = main.search(keyword);
            String datas[][] = new String[result.size()][3];
            int i = 0;
            for (com.google.api.services.drive.model.File temp : result) {
                datas[i][0] = temp.getId();
                datas[i][1] = temp.getName();
                datas[i][2] = temp.getMimeType();
                i++;
            }
            table_data.setRowCount(0);
            for (int row = 0; row < result.size(); row++) {
                    Object[] nye = {};
                    for (int col = 0; col < 3; col++){
                        nye = add(nye, datas[row][col]);   
                    }
                table_data.addRow(nye);
            }
        } catch (IOException ex) {
            Logger.getLogger(tampilan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cari_btnActionPerformed

    private void treeFolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeFolderMouseClicked
        String select = treeFolder.getLastSelectedPathComponent().toString();         
        String[] split = select.split("#");
        
        if(split.length == 1) {
            url.remove(url.get(url.size()-1).toString());
            //prev
            if(url.size() <= 2){
                treeFolder.setModel(new DefaultTreeModel(getStrukturFamily("root", "")));           
            }else{
                
                treeFolder.setModel(new DefaultTreeModel(getStrukturFamily(url.get(url.size()-1).toString(), split[0])));
            }
        } else {
            //next
            String id = split[1];
            url.add(id);
            treeFolder.setModel(new DefaultTreeModel(getStrukturFamily(id, split[0])));
        }
        TampilData();
        
       
        
    }//GEN-LAST:event_treeFolderMouseClicked
    
    private void open_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_btnActionPerformed
        String select = treeFolder.getLastSelectedPathComponent().toString();
        System.out.println(select);
    }//GEN-LAST:event_open_btnActionPerformed

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
    private javax.swing.JButton cari_btn;
    private javax.swing.JTable data_table;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton dowload_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyword_input;
    private javax.swing.JButton newFolder_btn;
    private javax.swing.JButton open_btn;
    private javax.swing.JTree treeFolder;
    private javax.swing.JButton upload_btn;
    // End of variables declaration//GEN-END:variables

}
