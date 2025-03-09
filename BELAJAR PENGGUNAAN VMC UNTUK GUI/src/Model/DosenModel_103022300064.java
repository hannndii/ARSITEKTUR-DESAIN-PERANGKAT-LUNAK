package Model;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DosenModel_103022300064 {
	private List<Dosen_103022300064> dosenList;
	private DefaultTableModel tableModel;
	
	public DosenModel_103022300064() {
		dosenList = new ArrayList<>();
		String[] coloumnNames = {"Nama Dosen", "Mata Kuliah Ajar"};
		tableModel = new DefaultTableModel(coloumnNames, 0);
	}
	
	public void addDosen(String nama, String mataKuliah) {
        Dosen_103022300064 dosen = new Dosen_103022300064(nama, mataKuliah);
        dosenList.add(dosen);
        tableModel.addRow(new Object[]{dosen.getName(), dosen.getMatKul()});
    }

    public void removeDosen(int index) {
        if (index >= 0 && index < dosenList.size()) {
            dosenList.remove(index);
            tableModel.removeRow(index);
        }
    }

    public void clearDosen() {
        dosenList.clear();
        tableModel.setRowCount(0);
    }
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
}
