package Soal01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ComboBox_103022300064 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBox_103022300064 frame = new ComboBox_103022300064();
					
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
	public ComboBox_103022300064() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] kendaraan = {"Mobil", "Motor", "Bus", "Sepeda"};
		JComboBox<String> comboBox = new JComboBox<>(kendaraan);
		comboBox.setBounds(10, 36, 100, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Daftar Jenis Kendaraan: ");
		lblNewLabel.setBounds(10, 11, 154, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnPilih = new JButton("Pilih");
		btnPilih.setBounds(120, 36, 80, 22);
		btnPilih.addActionListener(e -> {
			String pilihan = (String) comboBox.getSelectedItem();
			JOptionPane.showMessageDialog(this, "Anda memilih: " + pilihan);
		});
		contentPane.add(btnPilih);
	}
}
