package Soal05;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Table_103022300064 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtNamaKota;
    private JTextField txtPenduduk;
    private JTextField txtLuas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Table_103022300064 frame = new Table_103022300064();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Table_103022300064() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Data Kota di Indonesia");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(20, 10, 300, 20);
        contentPane.add(lblTitle);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Nama Kota", "Jumlah Penduduk", "Luas Wilayah (km²)"});

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 40, 540, 200);
        contentPane.add(scrollPane);

        JLabel lblNamaKota = new JLabel("Nama Kota:");
        lblNamaKota.setBounds(20, 250, 100, 20);
        contentPane.add(lblNamaKota);

        txtNamaKota = new JTextField();
        txtNamaKota.setBounds(120, 250, 150, 20);
        contentPane.add(txtNamaKota);

        JLabel lblPenduduk = new JLabel("Penduduk:");
        lblPenduduk.setBounds(20, 280, 100, 20);
        contentPane.add(lblPenduduk);

        txtPenduduk = new JTextField();
        txtPenduduk.setBounds(120, 280, 150, 20);
        contentPane.add(txtPenduduk);

        JLabel lblLuas = new JLabel("Luas Wilayah:");
        lblLuas.setBounds(20, 310, 100, 20);
        contentPane.add(lblLuas);

        txtLuas = new JTextField();
        txtLuas.setBounds(120, 310, 150, 20);
        contentPane.add(txtLuas);

        JButton btnTambah = new JButton("Tambah");
        btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String namaKota = txtNamaKota.getText();
                String penduduk = txtPenduduk.getText();
                String luas = txtLuas.getText();

                if (namaKota.isEmpty() || penduduk.isEmpty() || luas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Harap isi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    model.addRow(new Object[]{namaKota, penduduk, luas});
                    txtNamaKota.setText("");
                    txtPenduduk.setText("");
                    txtLuas.setText("");
                }
            }
        });
        btnTambah.setBounds(300, 250, 100, 25);
        contentPane.add(btnTambah);

        JButton btnHapus = new JButton("Hapus");
        btnHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    model.removeRow(selectedRow);
                }
            }
        });
        btnHapus.setBounds(300, 280, 100, 25);
        contentPane.add(btnHapus);
    }
}
