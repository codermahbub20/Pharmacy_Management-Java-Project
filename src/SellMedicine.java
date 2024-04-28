
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.TableModel;
import dao.PharmacyUtils;
import java.io.FileOutputStream;
import java.util.Date;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ahsan
 */
public class SellMedicine extends javax.swing.JFrame {

    public String numberPattern = "^[0.0-9.0]*$";
    private int finalTotalPrice = 0;
    private String billId = "";
    private String username = "";

    /**
     * Creates new form SellMedicine
     */
    public SellMedicine() {
        initComponents();
    }

    public SellMedicine(String tempUsername) {
        initComponents();
        username = tempUsername;
        setLocationRelativeTo(null);
    }

    private void medicineName(String nameOrUniqueId) {
        DefaultTableModel model = (DefaultTableModel) MedicineTable.getModel();
        model.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            ResultSet rt = stm.executeQuery("select *from medicine where name like '" + nameOrUniqueId + "%' or uniqueId like ' " + nameOrUniqueId + "%'");
            while (rt.next()) {
                model.addRow(new Object[]{rt.getString("uniqueId") + "- " + rt.getString("name")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void clearMedicineFields() {
        txtMedicineId.setText("");
        txtMedicineName.setText("");
        txtCompanyName.setText("");
        txtPricePerUnit.setText("");
        txtQuantity.setText("");
        txtTotalPrice.setText("");

    }

    public String getUniqeId(String prefix) {
        return prefix + System.nanoTime();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MedicineTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMedicineId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMedicineName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPricePerUnit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        btnAddToCart = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setText("SELL MEDICINE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, -10, 324, 62));

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Pharmacy management tools\\cancel001-icon-front-side.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 28, 29));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 394, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Search");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 52, -1));

        MedicineTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MedicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine"
            }
        ));
        MedicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MedicineTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 500));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Medicine ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 119, -1));

        txtMedicineId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(txtMedicineId, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 300, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Medicine Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 136, -1));

        txtMedicineName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(txtMedicineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 300, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Company Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 164, -1));

        txtCompanyName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 300, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Price per Unit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 120, 335, -1));

        txtPricePerUnit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPricePerUnit.setForeground(new java.awt.Color(51, 153, 0));
        txtPricePerUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPricePerUnitActionPerformed(evt);
            }
        });
        getContentPane().add(txtPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 120, 290, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Quantity");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, 98, -1));

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 0, 51));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 180, 290, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Total Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 97, -1));

        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTotalPrice.setForeground(new java.awt.Color(0, 0, 204));
        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 240, 290, -1));

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon("D:\\Pharmacy management tools\\Pharmacy Management System Images & Pattern\\Pharmacy Management System Images & Pattern\\add to cart.png")); // NOI18N
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 300, 213, 37));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setIcon(new javax.swing.ImageIcon("D:\\Pharmacy management tools\\Pharmacy Management System Images & Pattern\\Pharmacy Management System Images & Pattern\\generate bill & print.png")); // NOI18N
        jButton3.setText("Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 670, 192, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("BDT:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 670, 83, 40));

        lblFinalTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFinalTotalPrice.setForeground(new java.awt.Color(0, 0, 255));
        lblFinalTotalPrice.setText("0.00");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 680, 112, 24));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));

        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Id", "Medicine Name", "Company Name", "Quantity", "Price Per Unit", "Total Price"
            }
        ));
        CartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CartTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 830, 271));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 1460, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPriceActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        medicineName("");
        txtMedicineId.setEditable(false);
        txtMedicineName.setEditable(false);
        txtCompanyName.setEditable(false);
        txtPricePerUnit.setEditable(false);
        txtQuantity.setEditable(true);
        txtTotalPrice.setEditable(false);
// TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        String search = txtSearch.getText();
        medicineName(search);

// TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased

    private void MedicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineTableMouseClicked
        // TODO add your handling code here:
        int index = MedicineTable.getSelectedRow();
        TableModel model = MedicineTable.getModel();
        String nameOrUniqueId = model.getValueAt(index, 0).toString();

        String uniqueId[] = nameOrUniqueId.split("-", 0);

        try {
            Connection con = ConnectionProvider.getCon();
            Statement stm = con.createStatement();
            ResultSet rt = stm.executeQuery("select *from medicine where uniqueId =" + uniqueId[0] + "");
            while (rt.next()) {
                txtMedicineId.setText(uniqueId[0]);
                txtMedicineName.setText(rt.getString("Name"));
                txtCompanyName.setText(rt.getString("CompanyName"));
                txtPricePerUnit.setText(rt.getString("Price"));
                txtQuantity.setText("");
                txtTotalPrice.setText("");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_MedicineTableMouseClicked

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        // TODO add your handling code here:
        String Quantity = txtQuantity.getText();
        if (!Quantity.equals("")) {
            String price = txtPricePerUnit.getText();
            if (!Quantity.matches(numberPattern)) {
                JOptionPane.showMessageDialog(null, "Number of Quantity fields is invalid ! ");

            }
            int totalPrice = Integer.parseInt(Quantity) * Integer.parseInt(price);
            txtTotalPrice.setText(String.valueOf(totalPrice));
        } else {
            txtTotalPrice.setText("");
        }
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String Quantity = txtQuantity.getText();
        String uniqueId = txtMedicineId.getText();

        if (!Quantity.equals("") && !uniqueId.equals("")) {

            String PricePerUnit = txtPricePerUnit.getText();

            String MedicineName = txtMedicineName.getText();
            String CompanyName = txtCompanyName.getText();
            String TotalPrice = txtTotalPrice.getText();
            int checkStock = 0;
            int checkMedicineAlreadyExistInCart = 0;

            try {
                Connection con = ConnectionProvider.getCon();
                Statement stm = con.createStatement();
                ResultSet rt = stm.executeQuery("select *from medicine where uniqueID =" + uniqueId + " ");
                while (rt.next()) {
                    if (rt.getInt("quantity") >= Integer.parseInt(Quantity)) {

                        checkStock = 1;

                    } else {

                        JOptionPane.showMessageDialog(null, "Medicine is out of stock.Only " + rt.getInt("quantity") + "Left");

                    }

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);

            }
            if (checkStock == 1) {
                DefaultTableModel dtm = (DefaultTableModel) CartTable.getModel();
                if (CartTable.getRowCount() != 0) {
                    for (int i = 0; i < CartTable.getRowCount(); i++) {
                        if (Integer.parseInt(dtm.getValueAt(i, 0).toString()) == Integer.parseInt(uniqueId)) {
                            checkMedicineAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "This Medicine already exist in cart");
                        }

                    }
                }
                if (checkMedicineAlreadyExistInCart == 0) {

                    dtm.addRow(new Object[]{uniqueId, MedicineName, CompanyName, Quantity, PricePerUnit, TotalPrice});
                    finalTotalPrice = finalTotalPrice + Integer.parseInt(TotalPrice);
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Medicine Added Successfully ");
                }
                clearMedicineFields();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Medicine ID and Medicine Quantity field is required ! ");

        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void txtPricePerUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPricePerUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPricePerUnitActionPerformed

    private void CartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartTableMouseClicked
        // TODO add your handling code here:
        int index = CartTable.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this medicine?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {

            TableModel model = CartTable.getModel();
            String total = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(total);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) CartTable.getModel()).removeRow(index);

        }
    }//GEN-LAST:event_CartTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (finalTotalPrice != 0) {
            billId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) CartTable.getModel();
            if (CartTable.getRowCount() != 0) {
                for (int i = 0; i < CartTable.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement stm = con.createStatement();
                        stm.executeUpdate("update medicine set quantity =quantity-" + Integer.parseInt(dtm.getValueAt(i, 3).toString()) + " where uniqueId=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, e);

                    }

                }

            }
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into bill (billId,billDate,totalPaid,generatedBy) values(?,?,?,?)");
                ps.setString(1, billId);
                ps.setString(2, myFormat.format(cal.getTime()));
                ps.setInt(3, finalTotalPrice);
                ps.setString(4, username);
                ps.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            //Create Bill
            // Create Bill
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(PharmacyUtils.billPath + "" + billId + ".pdf"));
                doc.open();

                // Add pharmacy name to the PDF
                Paragraph pharmacyName = new Paragraph("                                                                   LIFE Pharmacy\n");
                doc.add(pharmacyName);

                // Add a star line separator
                Paragraph starLine = new Paragraph("****************************************************************************************************************");
                doc.add(starLine);

                // Placeholder for bill details (Bill ID and Date)
                Paragraph details = new Paragraph("\tBill ID: " + billId + "\nDate:" + new Date() + "\nTotal Paid: " + finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                PdfPTable tbl = new PdfPTable(6);
                tbl.addCell("Medicine ID");
                tbl.addCell("Medicine Name");
                tbl.addCell("Company Name");
                tbl.addCell("QTY");
                tbl.addCell("Price Per Unit");
                tbl.addCell("Total Price");
                for (int i=0;i<CartTable.getRowCount();i++){
                
                     String a= CartTable.getValueAt(i, 0).toString();
                     String b= CartTable.getValueAt(i, 1).toString();
                     String c= CartTable.getValueAt(i, 2).toString();                     
                     String d= CartTable.getValueAt(i, 3).toString();
                     String e= CartTable.getValueAt(i, 4).toString();
                     String f= CartTable.getValueAt(i, 5).toString();
                     tbl.addCell(a);
                     tbl.addCell(b);
                     tbl.addCell(c);
                     tbl.addCell(d);
                     tbl.addCell(e);
                     tbl.addCell(f);
                }
                doc.add(tbl);
                doc.add(starLine);
                Paragraph thanksMsg= new Paragraph("Thank you, Please Visit Again.\n Software Developed by:www.SpacebarCO.com | 01613805702");
                doc.add(thanksMsg);
                OpenPdf.openById(String.valueOf(billId));
                
            } catch (Exception e) {
                // Display an error message dialog if an exception occurs
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new SellMedicine(username).setVisible(true);

        }
        else{
        
            JOptionPane.showMessageDialog(null,"Please add some Medicine to Cart.");
        
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

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
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CartTable;
    private javax.swing.JTable MedicineTable;
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtMedicineId;
    private javax.swing.JTextField txtMedicineName;
    private javax.swing.JTextField txtPricePerUnit;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables

    private String getUniqueId(String prefix) {
       return prefix+System.nanoTime();
    }
}
