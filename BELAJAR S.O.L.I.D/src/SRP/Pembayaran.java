package SRP;

interface Bayar {
 void prosesPembayaran(double jumlah);
}

class PembayaranKartuKredit implements Bayar {
 @Override
 public void prosesPembayaran(double jumlah) {
     System.out.println("Memproses pembayaran dengan kartu kredit: Rp" + jumlah);
 }
}

class PembayaranPayPal implements Bayar {
 @Override
 public void prosesPembayaran(double jumlah) {
     System.out.println("Memproses pembayaran dengan PayPal: Rp" + jumlah);
 }
}

class PemrosesPembayaran {
 public void proses(Bayar metode, double jumlah) {
     metode.prosesPembayaran(jumlah);
 }
}

public class Pembayaran {
 public static void main(String[] args) {
     PemrosesPembayaran pemroses = new PemrosesPembayaran();
     pemroses.proses(new PembayaranKartuKredit(), 1000000);
     pemroses.proses(new PembayaranPayPal(), 2000000);
 }
}
