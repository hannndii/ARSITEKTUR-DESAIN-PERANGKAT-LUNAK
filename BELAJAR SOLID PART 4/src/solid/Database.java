package solid;

import java.sql.*;

public class Database implements interfaceClass{
	static final String url = "jdbc:mysql://localhost:3306/tpmod8";
    static final String user = "root";
    static final String pass = "";
    static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;
    
    public void connect() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
    }
    
    public void saveToDatabase(String nim, String nama, String prodi, String angkatan) {
        try {
            String sql = "INSERT INTO mahasiswa(nim, nama, prodi, angkatan) VALUES "
            		+ "('" 
            		+ nim 
            		+ "','" 
            		+ nama 
            		+ "','" 
            		+ prodi 
            		+ "','" 
            		+ angkatan 
            		+ "')";
            stmt.executeUpdate(sql);
            System.out.println("Data Mahasiswa Berhasil Ditambahkan");
        } catch (SQLException e) {
            System.out.println("Kesalahan Insert: " + e.getMessage());
        }
    }
    
    @Override
    public void studentExchange() {
        throw new UnsupportedOperationException("Mahasiswa ini tidak memiliki akses Student Exchange");
    }
    
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Kesalahan Menutup Koneksi: " + e.getMessage());
        }
    }
}
