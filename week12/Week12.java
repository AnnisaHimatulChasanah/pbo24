/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week12;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author annis
 */
public class Week12 {

    /**
     * @param args the command line arguments
     */
        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://127.0.0.1/week12";
        
        static final String USER = "root";
        static final String PASS = "";

        static Connection conn;
        static Statement stmt;
        static ResultSet rs;
        
        public static void main(String[] args) {
        // TODO code application logic here
        int id, tahun_terbit, penulis;
        String judul_buku;
        byte stok;
        int n;
        
        //membuat scanner baru
        Scanner input = new Scanner(System.in);
            System.out.println("Pilih Menu : ");
            System.out.println("1. Insert Data");
            System.out.println("2. Delete Data");
            System.out.println("3. Update Data");
            System.out.println("4. Menampilkan Data");
            System.out.print("Masukkan angka : ");
        n = input.nextInt();
        
            switch (n){
                case 1 :
                    System.out.print("Masukkan jumlah inputan : ");
                    n = input.nextInt();
                    for(int i = 0; i < n; i++)
                    {
                        System.out.println("Data ke-"+(i+1));
                        System.out.print("Masukkan ID : ");
                        id = input.nextInt();
                        input.nextLine();
                        //Ketika menggunakan Scanner untuk membaca angka dengan nextInt() atau nextByte(),
                        //Scanner tidak membaca baris baru (newline) setelah angka. Jadi, ketika Anda mencoba
                        //membaca teks berikutnya dengan nextLine(), Scanner membaca baris baru yang tersisa dari
                        //input angka sebelumnya, bukan teks yang harapkan.

                        System.out.print("Masukkan Judul Buku : ");
                        judul_buku = input.nextLine();

                        System.out.print("Masukkan Tahun Terbit : ");
                        tahun_terbit = input.nextInt();
                        input.nextLine();

                        System.out.print("Masukkan jumlah stok : ");
                        stok = input.nextByte();
                        input.nextLine();

                        System.out.print("Masukkan ID penulis : ");
                        penulis = input.nextInt();
                        insert(id, judul_buku, tahun_terbit, stok, penulis);
                    }
                     break; //UNTUK KELUAR DARI CASE SETELAH LOOP
                case 2 :
                    System.out.print("Masukkan ID buku yang ingin di hapus : ");
                    id = input.nextInt();

                    delete(id);
                    System.out.println("Data dengan ID " + id + " telah terhapus!");
                    break;
                case 3 :
                    System.out.print("Masukkan ID yang ingin diupdate : ");
                    id = input.nextInt();
                    input.nextLine();
                    
                    System.out.print("Masukkan judul buku baru : ");
                    judul_buku = input.nextLine();
                    
                    System.out.print("Masukkan Tahun terbit baru : ");
                    tahun_terbit = input.nextInt();
                    
                    System.out.print("Masukkan Stok baru : ");
                    stok = input.nextByte();
                    
                    System.out.print("Masukkan ID penulis baru : ");
                    penulis = input.nextInt();
                    
                    update(id, judul_buku, tahun_terbit, stok, penulis);
                    System.out.println("Data dengan ID "+ id + " telah diupdate");
                    input.close();
                    break;
                case 4 :
                    show();
                    break;
                default:
                System.out.println("Menu tidak valid.");
            }
        }
        
        public static void insert(int id, String judul_buku, int tahun_terbit, byte stok, int penulis)
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                
                String sql = "INSERT INTO buku (id, judul_buku, tahun_terbit, stok, penulis) VALUES (?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setInt(1, id);
                ps.setString(2, judul_buku);
                ps.setInt(3, tahun_terbit);
                ps.setByte(4, stok);
                ps.setInt(5, penulis);
                
                ps.execute();
                
                stmt.close();
                conn.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        public static void show()
        {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.createStatement();
                
                rs = stmt.executeQuery("SELECT * FROM buku");
                int i = 1;
                while(rs.next())
                {
                    System.out.println("Data ke-"+i);
                    System.out.println("Judul Buku : "+rs.getString("judul_buku"));
                    System.out.println("Tahun Terbit : "+rs.getString("tahun_terbit"));
                    System.out.println("Stok : "+rs.getString("stok"));
                    System.out.println("Penulis : "+rs.getString("Penulis"));
                    i++;
                }
                rs.close();
                stmt.close();
                conn.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
        public static void delete(int id){
            try{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.createStatement();
                
                String sql = "DELETE FROM buku WHERE id = ? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setInt(1, id);
                ps.executeUpdate(); //menjalankan perintah sql yang mengubah data dalam database
                ps.close(); //Ini akan melepaskan sumber daya yang digunakan oleh objek tersebut dan mencegah kebocoran memori.
                conn.close(); //. Ini akan menutup koneksi ke database dan melepaskan sumber daya yang terkait dengan koneksi tersebut.
            } catch(Exception e) {
                System.out.println("Terjadi Kesalahan");
            }
        }
        
            public static void update(int id, String judul_buku, int tahun_terbit, byte stok, int penulis){
                try{
                    Class.forName(JDBC_DRIVER);
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    stmt = conn.createStatement();

                    String sql = "UPDATE buku SET judul_buku=?, tahun_terbit=?, stok=?, penulis=? WHERE id = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);

                    ps.setString(1, judul_buku);
                    ps.setInt(2, tahun_terbit);
                    ps.setByte(3, stok);
                    ps.setInt(4, penulis);
                    ps.setInt(5, id);

                    ps.executeUpdate();
                    
                    // Select updated data
                    String selectSQL = "SELECT * FROM buku WHERE id=?";
                    ps = conn.prepareStatement(selectSQL);
                    ps.setInt(1, id);

                    rs = ps.executeQuery();

                    if(rs.next()) {
                        System.out.println("Data yang telah diupdate:");
                        System.out.println("ID Buku: " + rs.getInt("id"));
                        System.out.println("Judul Buku: " + rs.getString("judul_buku"));
                        System.out.println("Tahun Terbit: " + rs.getInt("tahun_terbit"));
                        System.out.println("Stok: " + rs.getByte("stok"));
                        System.out.println("Penulis: " + rs.getInt("penulis"));
                    }
                    rs.close();
                    ps.close();
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
}
