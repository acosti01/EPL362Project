package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class medical extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medical frame = new medical();
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
	public medical() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 11, 391, 33);
		contentPane.add(panel);
		
		JLabel lblMedicalStaff = new JLabel("Medical Staff");
		lblMedicalStaff.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblMedicalStaff);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(57, 78, 135, 45);
		contentPane.add(panel_1);
		
		JButton btnViewRecords = new JButton("View Records");
		btnViewRecords.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(btnViewRecords);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(57, 142, 135, 45);
		contentPane.add(panel_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnUpdate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(243, 78, 135, 45);
		contentPane.add(panel_3);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(243, 142, 135, 45);
		contentPane.add(panel_4);
		
		JButton btnDownload = new JButton("Download");
		btnDownload.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(btnDownload);
	}
}
