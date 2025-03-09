package Model;

import Model.Database_103022300064;
import Model.Mahasiswa_103022300064;
import java.util.List;
import java.util.Scanner;

public class Main_103022300064 {
    public static void main(String[] args) {
        Database_103022300064 db = new Database_103022300064();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu CRUD Mahasiswa:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Semua Mahasiswa");
            System.out.println("3. Edit Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Prodi: ");
                    String prodi = scanner.nextLine();
                    System.out.print("Masukkan Angkatan: ");
                    String angkatan = scanner.nextLine();
                    if (db.addMahasiswa(nim, nama, prodi, angkatan)) {
                        System.out.println("Mahasiswa berhasil ditambahkan!");
                    } else {
                        System.out.println("Gagal menambahkan mahasiswa.");
                    }
                    break;
                case 2:
                    List<Mahasiswa_103022300064> daftar = db.getAllMahasiswa();
                    if (daftar.isEmpty()) {
                        System.out.println("Belum ada data mahasiswa.");
                    } else {
                        System.out.println("Daftar Mahasiswa:");
                        for (Mahasiswa_103022300064 mhs : daftar) {
                            System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama() + ", Prodi: " + mhs.getProdi() + ", Angkatan: " + mhs.getAngkatan());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
                    String editNim = scanner.nextLine();
                    System.out.print("Nama baru: ");
                    String newNama = scanner.nextLine();
                    System.out.print("Prodi baru: ");
                    String newProdi = scanner.nextLine();
                    System.out.print("Angkatan baru: ");
                    String newAngkatan = scanner.nextLine();
                    if (db.updateMahasiswa(editNim, newNama, newProdi, newAngkatan)) {
                        System.out.println("Data mahasiswa berhasil diupdate!");
                    } else {
                        System.out.println("Gagal mengupdate. NIM tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    String deleteNim = scanner.nextLine();
                    if (db.deleteMahasiswa(deleteNim)) {
                        System.out.println("Mahasiswa berhasil dihapus!");
                    } else {
                        System.out.println("Gagal menghapus. NIM tidak ditemukan.");
                    }
                    break;
                case 5:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Opsi tidak valid!");
            }
        } while (pilihan != 5);

        db.close();
        scanner.close();
    }
}