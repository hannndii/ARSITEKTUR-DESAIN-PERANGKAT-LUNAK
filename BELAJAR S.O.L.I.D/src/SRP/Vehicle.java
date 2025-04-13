abstract class Kendaraan {
    abstract void nyalakanMesin();
}

class Mobil extends Kendaraan {
    @Override
    public void nyalakanMesin() {
        System.out.println("Mesin mobil menyala");
    }
}

class Sepeda {
    public void kayuh() {
        System.out.println("Mengayuh sepeda");
    }
}

public class Vehicle {
    public static void main(String[] args) {
        Kendaraan kendaraan1 = new Mobil();
        kendaraan1.nyalakanMesin(); 

        Sepeda kendaraan2 = new Sepeda();
        kendaraan2.kayuh(); 
    }
}