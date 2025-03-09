package Soal03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class CheckBox_103022300064 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBox_103022300064 frame = new CheckBox_103022300064();
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
	public CheckBox_103022300064() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apakah makanan favorit kamu?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(39, 20, 269, 14);
		contentPane.add(lblNewLabel);
		
		JCheckBox nasiGoreng = new JCheckBox("Nasi Goreng");
		nasiGoreng.setBounds(35, 50, 150, 23);
		contentPane.add(nasiGoreng);
		
		JCheckBox sateAyam = new JCheckBox("Sate Ayam");
		sateAyam.setBounds(35, 76, 150, 23);
		contentPane.add(sateAyam);
		
		JCheckBox bakso = new JCheckBox("Bakso");
		bakso.setBounds(35, 102, 150, 23);
		contentPane.add(bakso);
		
		JCheckBox mieAyam = new JCheckBox("Mie Ayam");
		mieAyam.setBounds(35, 128, 150, 23);
		contentPane.add(mieAyam);
		
		JButton btnTampilkan = new JButton("Tampilkan");
		btnTampilkan.setBackground(Color.DARK_GRAY);
		btnTampilkan.setForeground(Color.WHITE);
		btnTampilkan.setBounds(35, 180, 120, 23);
		btnTampilkan.addActionListener(e -> {
			StringBuilder pilihan = new StringBuilder("Makanan favorit Anda:");
			if (nasiGoreng.isSelected()) pilihan.append("\n- Nasi Goreng");
			if (sateAyam.isSelected()) pilihan.append("\n- Sate Ayam");
			if (bakso.isSelected()) pilihan.append("\n- Bakso");
			if (mieAyam.isSelected()) pilihan.append("\n- Mie Ayam");
			
			if (pilihan.toString().equals("Makanan favorit Anda:")) {
				JOptionPane.showMessageDialog(this, "Anda belum memilih makanan!");
			} else {
				JOptionPane.showMessageDialog(this, pilihan.toString());
			}
		});
		contentPane.add(btnTampilkan);
	}

}
