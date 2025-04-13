package solid;

public class Mahasiswa {
	protected String nim;
	protected String nama;
	protected String prodi;
	protected String angkatan;
    
    public Mahasiswa(String nim, String nama, String prodi, String angkatan) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.angkatan = angkatan;
    }
    
    public String getNim() { 
    	return nim; 
    	}
    public void setNim(String nim) { 
    	this.nim = nim; 
    	}

    public String getNama() { 
    	return nama; 
    	}
    public void setNama(String nama) { 
    	this.nama = nama; 
    	}

    public String getProdi() { 
    	return prodi; 
    	}
    public void setProdi(String prodi) { 
    	this.prodi = prodi; 
    	}

    public String getAngkatan() { 
    	return angkatan; 
    	}
    public void setAngkatan(String angkatan) { 
    	this.angkatan = angkatan; 
    	}
	
}
