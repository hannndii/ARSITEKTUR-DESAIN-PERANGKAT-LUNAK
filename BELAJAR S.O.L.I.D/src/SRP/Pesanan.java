package SRP;

import java.util.ArrayList;
import java.util.List;

class Pesan {
 private List<String> daftarBarang = new ArrayList<>();

 public void tambahBarang(String barang) {
     daftarBarang.add(barang);
 }

 public List<String> getDaftarBarang() {
     return daftarBarang;
 }
}

class StrukPrinter {
 public void cetakStruk(Pesan pesanan) {
     System.out.println("Struk Belanja:");
     for (String barang : pesanan.getDaftarBarang()) {
         System.out.println("- " + barang);
     }
 }
}

class DatabasePesanan {
 public void simpanKeDatabase(Pesan pesanan) {
     System.out.println("Menyimpan pesanan ke database...");
 }
}

public class Pesanan {

	public static void main(String[] args) {
        Pesan pesanan = new Pesan();
        pesanan.tambahBarang("Laptop");
        pesanan.tambahBarang("Mouse");

        StrukPrinter printer = new StrukPrinter();
        printer.cetakStruk(pesanan);

        DatabasePesanan database = new DatabasePesanan();
        database.simpanKeDatabase(pesanan);
    }

}
