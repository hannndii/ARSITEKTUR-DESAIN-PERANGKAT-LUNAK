package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database_103022300064 {
    private Connection conn;

    public Database_103022300064() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa_db", "root", "");
            System.out.println("Koneksi database berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi database gagal: " + e.getMessage());
        }
    }

    public boolean addMahasiswa(String nim, String nama, String prodi, String angkatan) {
        String sql = "INSERT INTO mahasiswa (nim, nama, prodi, angkatan) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nim);
            pstmt.setString(2, nama);
            pstmt.setString(3, prodi);
            pstmt.setString(4, angkatan);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan mahasiswa: " + e.getMessage());
            return false;
        }
    }

    public List<Mahasiswa_103022300064> getAllMahasiswa() {
        List<Mahasiswa_103022300064> daftarMahasiswa = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Mahasiswa_103022300064 mhs = new Mahasiswa_103022300064();
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("nama"));
                mhs.setProdi(rs.getString("prodi"));
                mhs.setAngkatan(rs.getString("angkatan"));
                daftarMahasiswa.add(mhs);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }
        return daftarMahasiswa;
    }

    public boolean updateMahasiswa(String nim, String nama, String prodi, String angkatan) {
        String sql = "UPDATE mahasiswa SET nama=?, prodi=?, angkatan=? WHERE nim=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nama);
            pstmt.setString(2, prodi);
            pstmt.setString(3, angkatan);
            pstmt.setString(4, nim);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Gagal mengupdate mahasiswa: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteMahasiswa(String nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nim);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Gagal menghapus mahasiswa: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}