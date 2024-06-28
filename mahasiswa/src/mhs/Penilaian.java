/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mhs;

/**
 *
 * @author annis
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class Penilaian extends javax.swing.JFrame {

    /**
     * Creates new form Penilaian
     */
    
    public class DBConnection{
        public Connection getConnection(){
            Connection con = null;
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/mahasiswa", "root", "");
                //JOptionPane.showMessageDialog(null, "Koneksi Sukses");
                return con;
            }catch(SQLException ex){
                java.util.logging.Logger.getLogger(Penilaian.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }
    DefaultTableModel tabel1;
    Object[] listMhs = new Object[9];
    int x = 0;
    DBConnection dbConn = new DBConnection();
    Connection con = dbConn.getConnection();
    public Penilaian(){
        initComponents();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error saat menampilkan data dari database", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        //getConnection();
        tabel1 =new DefaultTableModel();
        tableHasil.setModel(tabel1);
        tabel1.addColumn("No");
        tabel1.addColumn("Nim");
        tabel1.addColumn("Nama");
        tabel1.addColumn("Nilai Uts");
        tabel1.addColumn("Nilai Uas");
        tabel1.addColumn("Nilai Tugas");
        tabel1.addColumn("Nilai Akhir");
        tabel1.addColumn("Nilai Huruf");
        tabel1.addColumn("Predikat");
        setResizable(false);
        
        nUTS1.setEditable(false);
        nUAS1.setEditable(false);
        nTugas1.setEditable(false);
        nUTS2.setEditable(false);
        nTugas2.setEditable(false);
        nUAS2.setEditable(false);
        btnSimpan.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnHapus.setEnabled(false);
        btnProses1.setEnabled(false);
    }
    public void kosongkanTextField(){
        txtnNim.setText("");
        txtNama.setText("");
        nUTS.setText("");
        nUAS.setText("");
        nTugas.setText("");
        
        nUTS1.setText("");
        nUAS1.setText("");
        nTugas1.setText("");
        nUTS2.setText("");
        nTugas2.setText("");
        nUAS2.setText("");

    }
    public void prosesHitungNilai(){
        try{
            String ni = txtnNim.getText();  String na = txtNama.getText();
            Double ts = Double.parseDouble(nUTS.getText());
            Double as = Double.parseDouble(nUAS.getText());
            Double tgs = Double.parseDouble(nTugas.getText());
                
                mahasiswa m = new mahasiswa(ni, na, ts, as, tgs);
                // Mengatur nilai pada komponen-komponen GUI sesuai dengan nilai mahasiswa
                nUTS1.setText(String.valueOf(m.getNilai_uts()));
                nUAS1.setText(String.valueOf(m.getNilai_uas()));
                nTugas1.setText(String.valueOf(m.getNilai_tugas()));
                nUTS2.setText(String.valueOf(m.getNilai_akhir()));
                nUAS2.setText(String.valueOf(m.getNilai_huruf()));
                nTugas2.setText(m.getPredikat());
                btnSimpan.setEnabled(true);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Inputan Anda Kosong","Warning",JOptionPane.WARNING_MESSAGE);
        }

    }
    public ArrayList[] getMhsList() throws SQLException{      
        String queryCount = "SELECT COUNT(*) as c FROM mhs";
        Statement st;
        ResultSet rsCount, rs;       
        st = con.createStatement();        
        rsCount = st.executeQuery(queryCount);
        int sizeTable=0;

        while(rsCount.next()){
            sizeTable = rsCount.getInt("c");
        }       
        ArrayList[] mhsList = new ArrayList[sizeTable];       
        String query = "SELECT * FROM mhs";
                rs = st.executeQuery(query);

       int x=0;
        while(rs.next()){
            mhsList[x] = new ArrayList<>();
            mhsList[x].add(rs.getString("nim"));
            mhsList[x].add(rs.getString("nama"));
            mhsList[x].add(rs.getDouble("nilai_uts"));
            mhsList[x].add(rs.getDouble("nilai_uas"));
            mhsList[x].add(rs.getDouble("nilai_tugas"));
            mhsList[x].add(rs.getDouble("nilai_akhir"));
            mhsList[x].add(rs.getString("nilai_huruf"));
            mhsList[x].add(rs.getString("predikat"));
            x++;
        }
        return mhsList;
    }
    public void tampilkanDiTabel() throws SQLException{
        ArrayList[] list = getMhsList();
        DefaultTableModel model = (DefaultTableModel)tableHasil.getModel();
       
        Object[] row = new Object[9];
        for(int i = 0; i<list.length; i++){
            row[0] = i+1;
            row[1] = list[i].get(0); row[2] = list[i].get(1);
            row[3] = list[i].get(2); row[4] = list[i].get(3);
            row[5] = list[i].get(4); row[6] = list[i].get(5);
            row[7] = list[i].get(6); row[8] = list[i].get(7);

            model.addRow(row);
        }       
    }
    public void kosongkanTabel(){
        DefaultTableModel model = (DefaultTableModel)this.tableHasil.getModel();
        model.setRowCount(0);
    }
    public void terpilih(int index) throws SQLException{
        ArrayList[] list = getMhsList();
        txtnNim.setText((String) list[index].get(0));
        txtNama.setText((String) list[index].get(1));
        nUTS.setText((String) list[index].get(2).toString());
        nUAS.setText((String) list[index].get(3).toString());
        nTugas.setText((String) list[index].get(4).toString());
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
        jLabel2 = new javax.swing.JLabel();
        txtnNim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nUTS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nUAS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nTugas = new javax.swing.JTextField();
        btnProses = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnTambahLain = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        nUTS1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nUAS1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nTugas1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHasil = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        nUTS2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nUAS2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        nTugas2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnProses1 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("From Nilai Mahasiswa");

        jLabel2.setText("Nim");

        txtnNim.setToolTipText("Isikan NIM");

        jLabel3.setText("Nama");

        txtNama.setToolTipText("Isikan Nama");

        jLabel4.setText("Nilai UTS");

        nUTS.setToolTipText("Isikan Nilai UTS");
        nUTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nUTSActionPerformed(evt);
            }
        });

        jLabel5.setText("Nilai UAS");

        nUAS.setToolTipText("Isikan Nilai UAS");

        jLabel6.setText("Nilai Tugas");

        nTugas.setToolTipText("Isikan Nilai Tugas");

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnSimpan.setText("simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTambahLain.setText("Tambah Lain");
        btnTambahLain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahLainActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel7.setText("UTS 35%");

        jLabel8.setText("UAS 35%");

        jLabel9.setText("Tugas 30%");

        tableHasil.setModel(new javax.swing.table.DefaultTableModel(
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
        tableHasil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHasilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHasil);

        jLabel10.setText("Nilai Akhir");

        jLabel11.setText("Predikat");
        jLabel11.setToolTipText("");

        jLabel12.setText("Nilai Huruf");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnProses1.setText("Proses");
        btnProses1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProses1ActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nUTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nUAS1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nTugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(btnProses)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSimpan))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(nUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnTambahLain)
                                                .addGap(36, 36, 36)
                                                .addComponent(btnKeluar))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnProses1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHapus))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtnNim, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nUTS2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nUAS2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nTugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtnNim, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProses)
                            .addComponent(btnSimpan)
                            .addComponent(btnTambahLain))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProses1)
                    .addComponent(btnUpdate)
                    .addComponent(btnHapus))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nUTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nUAS1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nTugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nUTS2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nUAS2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nTugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nUTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nUTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nUTSActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        prosesHitungNilai();
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO mhs(nim, nama, nilai_uts, nilai_uas, nilai_tugas, nilai_akhir, nilai_huruf, predikat) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, txtnNim.getText());
            ps.setString(2, txtNama.getText());
            ps.setString(3, nUTS.getText());
            ps.setString(4, nUAS.getText());
            ps.setString(5, nTugas.getText());
            ps.setString(6, nUTS2.getText());
            ps.setString(7, nUAS2.getText());
            ps.setString(8, nTugas2.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data tersimpan");

            kosongkanTextField();
            kosongkanTabel();
            tampilkanDiTabel();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data tidak tersimpan");
            ex.printStackTrace(); // Tambahkan ini untuk melihat detail kesalahan pada konsol
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahLainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahLainActionPerformed
        // TODO add your handling code here:
        kosongkanTextField();
        btnSimpan.setEnabled(false);

    }//GEN-LAST:event_btnTambahLainActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
//        String updateQuery = null;
//        PreparedStatement ps = null;
        
        String updateQuery = "UPDATE mhs SET nim=?, nama=?, nilai_uts=?, nilai_uas=?, nilai_tugas=?, nilai_akhir=?, nilai_huruf=?, predikat=? " +
                         "WHERE nim=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setString(1, txtnNim.getText());
            ps.setString(2, txtNama.getText());
            ps.setString(3, nUTS.getText());
            ps.setString(4, nUAS.getText());
            ps.setString(5, nTugas.getText());
            ps.setString(6, nUTS2.getText());
            ps.setString(7, nUAS2.getText());
            ps.setString(8, nTugas2.getText());
            ps.setString(9, txtnNim.getText()); // nim untuk WHERE clause

            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak berhasil diupdate");
            }

            kosongkanTextField();
            kosongkanTabel();
            tampilkanDiTabel();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data tidak berhasil diupdate");
            ex.printStackTrace(); // Tambahkan ini untuk melihat detail kesalahan pada konsol
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM mhs WHERE nim = ?");
            String nimNya = txtnNim.getText();
            ps.setString(1, nimNya);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mahasiswa berhasil dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mahasiswa tidak berhasil dihapus");
            java.util.logging.Logger.getLogger(Penilaian.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                kosongkanTextField(); // Pastikan metode ini tidak menyebabkan NullPointerException
                kosongkanTabel(); // Pastikan metode ini tidak menyebabkan NullPointerException
                tampilkanDiTabel(); // Pastikan metode ini tidak menyebabkan SQLException
            } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Penilaian.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tableHasilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHasilMouseClicked
        // TODO add your handling code here:
        int index = tableHasil.getSelectedRow();
        try {
            terpilih(index);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Penilaian.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnProses1.setEnabled(true);
        btnHapus.setEnabled(true);

    }//GEN-LAST:event_tableHasilMouseClicked

    private void btnProses1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProses1ActionPerformed
        // TODO add your handling code here:
        prosesHitungNilai();
        btnUpdate.setEnabled(true);

    }//GEN-LAST:event_btnProses1ActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Penilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penilaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnProses1;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahLain;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nTugas;
    private javax.swing.JTextField nTugas1;
    private javax.swing.JTextField nTugas2;
    private javax.swing.JTextField nUAS;
    private javax.swing.JTextField nUAS1;
    private javax.swing.JTextField nUAS2;
    private javax.swing.JTextField nUTS;
    private javax.swing.JTextField nUTS1;
    private javax.swing.JTextField nUTS2;
    private javax.swing.JTable tableHasil;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtnNim;
    // End of variables declaration//GEN-END:variables
}
