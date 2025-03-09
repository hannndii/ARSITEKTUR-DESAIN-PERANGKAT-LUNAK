package Controller;

import Model.DosenModel_103022300064;
import View.DosenView_103022300064;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandling_103022300064 {
    private DosenModel_103022300064 model;
    private DosenView_103022300064 view;
    
    public EventHandling_103022300064(DosenModel_103022300064 model, DosenView_103022300064 view) {
        this.model = model;
        this.view = view;
        this.view.getTable().setModel(model.getTableModel());
        
        view.getBtnTambah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = view.getTextField().getText();
                String mataKuliah = view.getTextField_1().getText();
                if (!nama.isEmpty() && !mataKuliah.isEmpty()) {
                    model.addDosen(nama, mataKuliah);
                    view.getTextField().setText(""); 
                    view.getTextField_1().setText(""); 
                }
            }
        });
        
        view.getBtnHapus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow != -1) {
                    model.removeDosen(selectedRow);
                }
            }
        });
        
        view.getBtnClear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clearDosen();
            }
        });
    }
}