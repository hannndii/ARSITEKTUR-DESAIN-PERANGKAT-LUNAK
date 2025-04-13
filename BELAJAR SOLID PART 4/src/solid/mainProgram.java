package solid;
import java.util.Scanner;


public class mainProgram {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Program Mahasiswa (SOLID Version) ===");

        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Prodi: ");
        String prodi = input.nextLine();

        System.out.print("Masukkan Angkatan: ");
        String angkatan = input.nextLine();

        System.out.print("Status Mahasiswa (1. Reguler | 2. Internasional): ");
        int status = input.nextInt();

        Mahasiswa mhs;
        if (status == 2) {
            mhs = new MahasiswaInternasional(nim, nama, prodi, angkatan);
            
        } else {
            mhs = new MahasiswaReguler(nim, nama, prodi, angkatan);
        }

        Database repo = new Database();
        repo.connect();
        repo.saveToDatabase(nim, nama, prodi, angkatan);

        if (mhs instanceof interfaceClass) {
            ((interfaceClass) mhs).studentExchange();
        } else {
            System.out.println("Mahasiswa ini tidak berhak mengikuti Student Exchange.");
        }

        System.out.println("Program Selesai.");
    }

}
