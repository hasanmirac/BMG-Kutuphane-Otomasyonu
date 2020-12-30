/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import main.DbHelper;

/**
 *
 * @author hasan
 */
public class Purchased_books extends javax.swing.JFrame {

    java.util.Date sqldate;
    java.util.Date temp;
    java.sql.Date to;
    java.sql.Date from;

    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public Purchased_books() {
        super("Purchased Book");
        initComponents();
        connection = DbHelper.ConnectDb();
    }

    /*public  ArrayList<Purchased_books> ListPurchased (String ValToSearch){
        
        ArrayList<Purchased_books> ListPurchased = new ArrayList<Purchased_books>();
        
        
        
        try{
            String sql = "select * from issue where issue.student_id like '%"+ValToSearch+"%'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String book_id = resultSet.getString("name");
                String name = resultSet.getString("book_id");
                String edition = resultSet.getString("edition");
                String writer = resultSet.getString("writer");
                String price = resultSet.getString("price");
                String pages = resultSet.getString("pages");
                String student_id = resultSet.getString("student_id");
                String s_name = resultSet.getString("s_name");
                String f_name = resultSet.getString("f_name");
                String division = resultSet.getString("division");
                String year = resultSet.getString("year");
                String date = resultSet.getString("date_of_issue");
            
            }
            
        } catch(Exception exception){
            
            System.out.println(exception.getMessage());
        }
        
          return ListPurchased;
    }
    
    public void findPurchased(){
    
            ArrayList<Purchased_books> = ListPurchased(jTextField1.getText());
    
}*/
    public void filter() {
        try {
            String sql = "select * from issue where issue.student_id like '%?%'";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, jTextField1.getText());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String book_id = resultSet.getString("name");
                String name = resultSet.getString("book_id");
                String edition = resultSet.getString("edition");
                String writer = resultSet.getString("writer");
                String price = resultSet.getString("price");
                String pages = resultSet.getString("pages");
                String student_id = resultSet.getString("student_id");
                String s_name = resultSet.getString("s_name");
                String f_name = resultSet.getString("f_name");
                String division = resultSet.getString("division");
                String year = resultSet.getString("year");
                String date = resultSet.getString("date_of_issue");

                String tbData[] = {book_id, name, edition, writer, price, pages, student_id, s_name, division, year, date};
                DefaultTableModel tblModel = (DefaultTableModel) tblPurchased.getModel();

                tblModel.addRow(tbData);

            }

        } catch (Exception exception) {

        }

    }

    public void table() {
        try {
            String sql = "select * from issue";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String book_id = resultSet.getString("book_id");
                String name = resultSet.getString("name");
                String edition = resultSet.getString("edition");
                String writer = resultSet.getString("writer");
                String price = resultSet.getString("price");
                String pages = resultSet.getString("pages");
                String student_id = resultSet.getString("student_id");
                String s_name = resultSet.getString("s_name");
                String f_name = resultSet.getString("f_name");
                String division = resultSet.getString("division");
                String year = resultSet.getString("year");
                String date = resultSet.getString("date_of_issue");

                String tbData[] = {book_id, name, edition, writer, price, pages, student_id, s_name, division, year, date};
                DefaultTableModel tblModel = (DefaultTableModel) tblPurchased.getModel();

                tblModel.addRow(tbData);

            }

        } catch (Exception exception) {

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPurchased = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        btnList = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPurchased.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Edition", "Writer", "Price", "Pages", "Student ID", "Student Name", "Division", "Year", "Date of Issue"
            }
        ));
        tblPurchased.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPurchasedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPurchased);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\hasan\\OneDrive\\Belgeler\\NetBeansProjects\\VirtualLibrarySystem\\src\\icons\\back.png")); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Purchased");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Book");

        jDateChooser1.setDateFormatString("MM/dd/yyyy");

        jDateChooser2.setDateFormatString("MM/dd/yyyy");

        btnList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnList.setText("List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Select your date range");

        jLabel5.setText("From ");

        jLabel6.setText("To");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnList)
                                .addGap(52, 52, 52)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(24, 24, 24)))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(61, 61, 61))))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(btnList)
                .addGap(60, 60, 60)
                .addComponent(btnBack)
                .addGap(106, 106, 106))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        setVisible(false);
        AdminHome aHome = new AdminHome();
        aHome.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblPurchasedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPurchasedMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) tblPurchased.getModel();

        String book_id = tblModel.getValueAt(tblPurchased.getSelectedRow(), 0).toString();
        String name = tblModel.getValueAt(tblPurchased.getSelectedRow(), 1).toString();
        String edition = tblModel.getValueAt(tblPurchased.getSelectedRow(), 2).toString();
        String writer = tblModel.getValueAt(tblPurchased.getSelectedRow(), 3).toString();
        String price = tblModel.getValueAt(tblPurchased.getSelectedRow(), 4).toString();
        String pages = tblModel.getValueAt(tblPurchased.getSelectedRow(), 5).toString();
        String student_id = tblModel.getValueAt(tblPurchased.getSelectedRow(), 6).toString();
        String student_name = tblModel.getValueAt(tblPurchased.getSelectedRow(), 7).toString();
        String division = tblModel.getValueAt(tblPurchased.getSelectedRow(), 8).toString();
        String year = tblModel.getValueAt(tblPurchased.getSelectedRow(), 9).toString();
        String date_of_issue = tblModel.getValueAt(tblPurchased.getSelectedRow(), 10).toString();

    }//GEN-LAST:event_tblPurchasedMouseClicked

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed

        tblPurchased.setModel(new DefaultTableModel(null, new String[]{"Book ID", "Name", "Edition", "Writer", "Price", "Pages", "Student ID", "Student Name", "Division", "Year", "Date of Issue"}));

        String sql = "select * from issue where date_of_issue between ? and ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            sqldate = jDateChooser1.getDate();
            from = new java.sql.Date(sqldate.getTime());

            temp = jDateChooser2.getDate();
            to = new java.sql.Date(temp.getTime());

            preparedStatement.setDate(1, from);
            preparedStatement.setDate(2, to);

            //preparedStatement.setString(1, ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText());
            //preparedStatement.setString(2, ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String book_id = resultSet.getString("book_id");
                String name = resultSet.getString("name");
                String edition = resultSet.getString("edition");
                String writer = resultSet.getString("writer");
                String price = resultSet.getString("price");
                String pages = resultSet.getString("pages");
                String student_id = resultSet.getString("student_id");
                String s_name = resultSet.getString("s_name");
                String f_name = resultSet.getString("f_name");
                String division = resultSet.getString("division");
                String year = resultSet.getString("year");
                String date = resultSet.getString("date_of_issue");

                String tbData[] = {book_id, name, edition, writer, price, pages, student_id, s_name, division, year, date};
                DefaultTableModel tblModel = (DefaultTableModel) tblPurchased.getModel();

                tblModel.addRow(tbData);

            }

        } catch (Exception exception) {

        }


    }//GEN-LAST:event_btnListActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        filter();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Purchased_books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchased_books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchased_books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchased_books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchased_books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnList;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblPurchased;
    // End of variables declaration//GEN-END:variables
}
