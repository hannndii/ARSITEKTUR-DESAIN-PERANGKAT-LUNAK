package Soal04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

public class RadioButton_103022300064 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButton_103022300064 frame = new RadioButton_103022300064();
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
	public RadioButton_103022300064() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Admin");
		rdbtnNewRadioButton.setBounds(32, 82, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("User");
		rdbtnNewRadioButton_1.setBounds(32, 108, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Guest");
		rdbtnNewRadioButton_2.setBounds(32, 134, 111, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);
        group.add(rdbtnNewRadioButton_2);

        JButton btnKonfirmasi = new JButton("Konfirmasi");
        btnKonfirmasi.setForeground(Color.WHITE);
        btnKonfirmasi.setBackground(Color.DARK_GRAY);
        btnKonfirmasi.setBounds(32, 186, 111, 23);
        btnKonfirmasi.addActionListener(e -> {
            String pilihan = "";
            if (rdbtnNewRadioButton.isSelected()) {
                pilihan = "Admin";
            } else if (rdbtnNewRadioButton_1.isSelected()) {
                pilihan = "User";
            } else if (rdbtnNewRadioButton_2.isSelected()) {
                pilihan = "Guest";
            }

            if (pilihan.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Anda belum memilih!");
            } else {
                JOptionPane.showMessageDialog(this, "Anda memilih: " + pilihan);
            }
		});
		contentPane.add(btnKonfirmasi);
		
		JLabel lblNewLabel = new JLabel("Pilih jenis akun");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(32, 40, 271, 14);
		contentPane.add(lblNewLabel);
	}
}
