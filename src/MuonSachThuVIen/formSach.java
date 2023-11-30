/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MuonSachThuVIen;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class formSach extends javax.swing.JFrame {

    private ThuVienService TVS = new ThuVienService();
    private DefaultTableModel model = new DefaultTableModel();

    public formSach() {
        initComponents();
        loadTable(TVS.getAll());

      

    }

    private void loadTable(List<listSach> LSach) {
        model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        for (listSach sach : LSach) {
            model.addRow(sach.toDataRow());
            
        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnShowDetail = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sách", "Thể loại", "Tác giả"
            }
        ));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSach);

        btnSearch.setText("Tìm Kiếm ");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnShowDetail.setText("Xem chi tiết");
        btnShowDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDetailActionPerformed(evt);
            }
        });

        btnExit.setText("Đóng");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnShowDetail)
                    .addComponent(btnExit))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = javax.swing.JOptionPane.showInputDialog(this, "Nhập từ khóa tìm kiếm:");

        if (keyword != null && !keyword.trim().isEmpty()) {
            

            List<listSach> searchResult = TVS.searchSach(keyword);
            loadTable(searchResult);
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập từ khóa tìm kiếm.");

        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnShowDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDetailActionPerformed
        int selectedRow = tblSach.getSelectedRow();
        if (selectedRow != -1) {
            String tenSach = tblSach.getValueAt(selectedRow, 0).toString();
            String theLoai = tblSach.getValueAt(selectedRow, 1).toString();
            String tacGia = tblSach.getValueAt(selectedRow, 2).toString();

            formDetail chiTietSach = new formDetail();
            chiTietSach.updateBookInfo(tenSach, theLoai, tacGia);
            chiTietSach.setVisible(true);
            
            
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một quyển sách để xem chi tiết.");
        }
    }//GEN-LAST:event_btnShowDetailActionPerformed

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked

    }//GEN-LAST:event_tblSachMouseClicked
    private void searchBook(String keyword, List<listSach> ls) {
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        boolean found = false;
        for (listSach sach : ls) {
            if (sach.getTenSach().toLowerCase().contains(keyword.toLowerCase())) {
            found = true;
            Object[] rowData = {sach.getTenSach(), sach.getTheLoai(), sach.getTacGia()};
            model.addRow(rowData);
        }
            
        }

        

        if (found) {
            JOptionPane.showMessageDialog(this, "Đã tìm thấy sách với từ khóa: " + keyword);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sách nào với từ khóa: " + keyword);
            return;
        }
    }

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
            java.util.logging.Logger.getLogger(formSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowDetail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSach;
    // End of variables declaration//GEN-END:variables
}
