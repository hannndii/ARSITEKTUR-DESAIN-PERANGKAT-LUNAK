package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EventHandling_103022300064;
import Model.DosenModel_103022300064;
import View.DosenView_103022300064;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DosenView_103022300064 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	JButton btnNewButton, btnNewButton_1, btnNewButton_2;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DosenModel_103022300064 model = new DosenModel_103022300064();
			        DosenView_103022300064 view = new DosenView_103022300064();
			        EventHandling_103022300064 controller = new EventHandling_103022300064(model, view);
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DosenView_103022300064() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(394, 429, 154, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nama");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(295, 432, 49, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(394, 474, 154, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mata Kuliah");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(295, 475, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Tambah");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(244, 536, 95, 36);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Hapus");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(398, 536, 95, 36);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(551, 536, 95, 36);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 68, 763, 303);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel_2 = new JLabel("DAFTAR INFORMASI DOSEN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(311, 28, 300, 14);
		contentPane.add(lblNewLabel_2);
	}
	
	public JButton getBtnTambah() {
	    return btnNewButton;
	}

	public JButton getBtnHapus() {
	    return btnNewButton_1;
	}

	public JButton getBtnClear() {
	    return btnNewButton_2;
	}
	
	public JTextField getTextField() {
		return textField;
	}
	
	public JTextField getTextField_1() {
		return textField_1;
	}
	
	public JTable getTable() {
		return table;
	}
}
