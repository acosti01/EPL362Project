package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class MedicalRecordsStaff_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public MedicalRecordsStaff_GUI() {
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 799);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		

		JTabbedPane tabbedPane = new JTabbedPane();
		setLocationRelativeTo(null);
		setContentPane(tabbedPane);
		
		JPanel tab1 = new JPanel();
		tab1.setBorder(new EmptyBorder(5,5,5,5));
		tab1.setLayout(null);
		tabbedPane.addTab("Manage Personel", tab1);
		tab1.setBackground(SystemColor.activeCaption);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MedicalRecordsStaff_GUI.class.getResource("/img/medical_record_staff.png")));
		lblNewLabel_2.setBounds(29, 42, 429, 246);
		tab1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Manage Personel");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setBounds(453, 227, 341, 46);
		tab1.add(lblNewLabel_3);
		
		JList list = new JList();
		list.setBounds(58, 341, 1164, 392);
		tab1.add(list);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(1278, 340, 58, 54);
		tab1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/pencil.png")));
		btnNewButton_1.setBounds(1278, 530, 58, 54);
		tab1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(MedicalRecordsStaff_GUI.class.getResource("/img/eyes.jpg")));
		btnNewButton_2.setBounds(1278, 435, 58, 54);
		tab1.add(btnNewButton_2);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/delete.png")));
		button.setBounds(1278, 690, 58, 54);
		tab1.add(button);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(MedicalRecordsStaff_GUI.class.getResource("/img/refresh.png")));
		btnNewButton_5.setBounds(1278, 610, 58, 54);
		tab1.add(btnNewButton_5);
		
		JPanel tab2 = new JPanel();
		tab2.setBackground(SystemColor.activeCaption);
		tab2.setBorder(new EmptyBorder(5,5,5,5));
		tab2.setLayout(null);
		tabbedPane.addTab("Handle change request", tab2);
		
	
		
		JLabel lblPatientRecords = new JLabel("Request for changes ");
		lblPatientRecords.setForeground(new Color(0, 0, 51));
		lblPatientRecords.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPatientRecords.setBounds(542, 251, 309, 46);
		tab2.add(lblPatientRecords);
		
		JList list_1 = new JList();
		list_1.setBounds(41, 325, 1215, 336);
		tab2.add(list_1);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/eyes.jpg")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_1.setBounds(1278, 325, 58, 54);
		tab2.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/pencil.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_2.setBounds(1278, 410, 58, 54);
		tab2.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/delete.png")));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_3.setBounds(1278, 596, 58, 54);
		tab2.add(button_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/request.png")));
		lblNewLabel_4.setBounds(10, 63, 237, 234);
		tab2.add(lblNewLabel_4);
		
		
		JPanel tab3 = new JPanel();
		tab3.setBackground(SystemColor.activeCaption);
		tab3.setBorder(new EmptyBorder(5,5,5,5));
		tab3.setLayout(null);
		tabbedPane.addTab("Report a deceased patient ", tab3);
		
		JLabel lblReportADeath = new JLabel("Report a death...");
		lblReportADeath.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReportADeath.setBounds(44, 76, 238, 54);
		tab3.add(lblReportADeath);
		
		JLabel lblNewLabel = new JLabel("Patient's ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(188, 203, 128, 47);
		tab3.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(340, 206, 353, 47);
		tab3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Report");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(593, 283, 89, 30);
		tab3.add(btnNewButton_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MedicalRecordsStaff_GUI.class.getResource("/img/death.png")));
		label.setBounds(803, 22, 213, 217);
		tab3.add(label);
		
		JButton btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(494, 283, 89, 30);
		tab3.add(btnNewButton_4);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(MedicalRecordsStaff_GUI.class.getResource("/img/refresh.png")));
		button_4.setBounds(1278, 515, 58, 54);
		tab2.add(button_4);

		setVisible(true);
	}
}
