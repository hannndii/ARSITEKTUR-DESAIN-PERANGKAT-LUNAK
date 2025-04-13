package solid;

public class MahasiswaInternasional extends Mahasiswa implements interfaceClass{
	public MahasiswaInternasional(String nim, String nama, String prodi, String angkatan) {
        super(nim, nama, prodi, angkatan);
    }
	
	@Override
	public void studentExchange() {
		System.out.println("Berhak mengikuti Program Student Exchange ke luar negeri");
	}
}
