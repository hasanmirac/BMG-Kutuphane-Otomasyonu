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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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
    
    DefaultTableModel tblModel; 

    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public Purchased_books() {
        super("Purchased Book");
        initComponents();
        connection = DbHelper.ConnectDb();
    }

   
    public void filterPublisher(String query){
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tblModel);
        tblPurchased.setRowSorter(tr);
        
        if(query != "None")
        {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else 
        {
            tblPurchased.setRowSorter(tr);
        }   
    }
    
     public void filterWriter(String query){
         
         TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tblModel);
        tblPurchased.setRowSorter(tr);
        
        if(query != "None")
        {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else 
        {
            tblPurchased.setRowSorter(tr);
        }   
        
    }
    
    
    public void StudentidFilter() {
        tblPurchased.setModel(new DefaultTableModel(null, new String[]{"Book ID", "Name", "Edition", "Writer", "Price", "Pages", "Student ID", "Student Name", "Division", "Year", "Date of Issue"}));
        try {
            String sql = "select * from issue where student_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, txtStudentid.getText());
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
    
    public void BookidFilter(){
    
    tblPurchased.setModel(new DefaultTableModel(null, new String[]{"Book ID", "Name", "Edition", "Writer", "Price", "Pages", "Student ID", "Student Name", "Division", "Year", "Date of Issue"}));
        try {
            String sql = "select * from issue where book_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, txtBookid.getText());
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
        cmbWriter = new javax.swing.JComboBox<>();
        cmbPublisher = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStudentid = new javax.swing.JTextField();
        btnStudentidSearch = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtBookid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBookidSearch = new javax.swing.JButton();
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
        if (tblPurchased.getColumnModel().getColumnCount() > 0) {
            tblPurchased.getColumnModel().getColumn(0).setHeaderValue("Book ID");
            tblPurchased.getColumnModel().getColumn(1).setHeaderValue("Name");
            tblPurchased.getColumnModel().getColumn(2).setHeaderValue("Edition");
            tblPurchased.getColumnModel().getColumn(3).setHeaderValue("Writer");
            tblPurchased.getColumnModel().getColumn(4).setHeaderValue("Price");
            tblPurchased.getColumnModel().getColumn(5).setHeaderValue("Pages");
            tblPurchased.getColumnModel().getColumn(6).setHeaderValue("Student ID");
            tblPurchased.getColumnModel().getColumn(7).setHeaderValue("Student Name");
            tblPurchased.getColumnModel().getColumn(8).setHeaderValue("Division");
            tblPurchased.getColumnModel().getColumn(9).setHeaderValue("Year");
            tblPurchased.getColumnModel().getColumn(10).setHeaderValue("Date of Issue");
        }

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

        cmbWriter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbWriter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Craig Silvey", "Dostoyevski", "Edip Cansever", "John Steinbeck", "Jules Verne", "Maurice Leblanc", "Paulo Coelho", "Sarah Jio", "Yaşar Kemal", "None" }));
        cmbWriter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbWriterİtemStateChanged(evt);
            }
        });

        cmbPublisher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbPublisher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Altın Kitaplar", "Alfa Yayınları", "Damla Yayınevi ", "Koridor Yayınları", "Martı Yayınları", "Timaş Yayınları", "Toros Yayınları", "Yapı Kredi Yayınları", "None", " " }));
        cmbPublisher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPublisherİtemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Writer:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Publisher:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Student ID:");

        btnStudentidSearch.setText("Search");
        btnStudentidSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentidSearchActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Filter");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Book ID:");

        btnBookidSearch.setText("Search");
        btnBookidSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookidSearchActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(480, 480, 480)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtStudentid))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(170, 170, 170)
                                        .addComponent(btnBookidSearch))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(98, 98, 98)
                                        .addComponent(cmbWriter, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel10)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtBookid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnList)
                                    .addGap(52, 52, 52))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(20, 20, 20)))
                            .addComponent(jLabel1))
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnStudentidSearch)
                        .addGap(303, 303, 303))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(80, 80, 80)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(47, 47, 47))
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addComponent(btnList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbWriter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtBookid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStudentidSearch)
                            .addComponent(btnBookidSearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 96, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1075, 610));
        setLocationRelativeTo(null);
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

    private void cmbPublisherİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPublisherİtemStateChanged
        String query = cmbPublisher.getSelectedItem().toString();
        
        filterPublisher(query);
    }//GEN-LAST:event_cmbPublisherİtemStateChanged

    private void cmbWriterİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbWriterİtemStateChanged
        String query = cmbWriter.getSelectedItem().toString();
        
        filterWriter(query);
    }//GEN-LAST:event_cmbWriterİtemStateChanged

    private void btnStudentidSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentidSearchActionPerformed
        StudentidFilter();
    }//GEN-LAST:event_btnStudentidSearchActionPerformed

    private void btnBookidSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookidSearchActionPerformed
        BookidFilter();
    }//GEN-LAST:event_btnBookidSearchActionPerformed

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
    private javax.swing.JButton btnBookidSearch;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnStudentidSearch;
    private javax.swing.JComboBox<String> cmbPublisher;
    private javax.swing.JComboBox<String> cmbWriter;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPurchased;
    private javax.swing.JTextField txtBookid;
    private javax.swing.JTextField txtStudentid;
    // End of variables declaration//GEN-END:variables
}
