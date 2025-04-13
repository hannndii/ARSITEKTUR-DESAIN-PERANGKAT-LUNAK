package DIP;

interface PaymentMethod {
    void bayar(double jumlah);
}

class Gopay implements PaymentMethod {
    public void bayar(double jumlah) {
        System.out.println("Bayar dengan GoPay: Rp" + jumlah);
    }
}

class Transaksi {
    private PaymentMethod paymentMethod;
    
    public Transaksi(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void prosesBayar(double jumlah) {
        paymentMethod.bayar(jumlah);
    }
}
