package Soal02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Button_103022300064 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Button_103022300064 frame = new Button_103022300064();
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
	public Button_103022300064() {
		JLabel label = new JLabel("Pilih Warna");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		
		setTitle("trialButton");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Buttton 1");
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Warna yang dipilih: Hijau");
			}
		});
		btnNewButton.setBounds(30, 206, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Button 2");
		btnNewButton_1.setForeground(Color.YELLOW);
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Warna yang dipilih: Kuning");
			}
		});
		btnNewButton_1.setBounds(182, 206, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Button 3");
		btnNewButton_2.setForeground(Color.MAGENTA);
		btnNewButton_2.setBackground(Color.MAGENTA);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("Warna yang dipilih: Ungu");
			}
		});
		btnNewButton_2.setBounds(337, 206, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		label.setBounds(65, 121, 306, 14);
		contentPane.add(label);
	}
}
