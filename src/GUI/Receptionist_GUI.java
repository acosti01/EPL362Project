package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entities.User;
import rmiinterface.RMIInterface;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Receptionist_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel myPanel = new JPanel();
	JTextField id = new JTextField(20);
	JTextField name = new JTextField(20);
	JTextField surname = new JTextField(20);
	JTextField email = new JTextField(20);
	JTextField address = new JTextField(20);
	JTextField telephone = new JTextField(20);
	JTextField birthday = new JTextField(20);
	JTextField gender = new JTextField(20);

	Object[][] patientsEntry;
	String[] patientsColumns = { "ID", "Name", "Surname", "Email", "Address",
			"Phone Number", "Birthday", "Gender" };
	DefaultTableModel patientstableModel;
	JTable patientsTable;
	JScrollPane patientsscrollpane;

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Receptionist_GUI(User user, RMIInterface look_up)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException,
			SQLException, RemoteException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JTabbedPane tabbedPane = new JTabbedPane();
		setLocationRelativeTo(null);
		setContentPane(tabbedPane);

		JPanel tab1 = new JPanel();
		tab1.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab1.setLayout(null);
		tabbedPane.addTab("Diary", tab1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/receptionist.png")));
		lblNewLabel.setBounds(811, 0, 215, 256);
		tab1.add(lblNewLabel);
		tab1.setBackground(new Color(0, 255, 255));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/diary.png")));
		lblNewLabel_2.setBounds(21, 42, 429, 246);
		tab1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Appointment Diary");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setBounds(391, 227, 376, 46);
		tab1.add(lblNewLabel_3);

		// *********************FILL_DIARY*********************************
		Object[][] diaryEntry;
		diaryEntry = look_up.fillDiary();
		String[] diaryColumns = { "ID", "Name", "Surname", "Phone Number",
				"Date", "Clinicians First Name", "Clinicians Last Name",
				"Clinic", "Time", "Type" };
		DefaultTableModel diarytableModel = new DefaultTableModel(diaryEntry,
				diaryColumns);
		JTable diaryTable = new JTable(diarytableModel);
		diaryTable.setBounds(57, 310, 812, 325);
		diaryTable.getTableHeader().setBackground(Color.pink);
		diaryTable.getTableHeader().setForeground(Color.blue);
		;
		Font tf = new Font("Appointments", Font.BOLD, 12);
		diaryTable.getTableHeader().setFont(tf);
		JScrollPane scrollpane = new JScrollPane(diaryTable);
		scrollpane.setBounds(57, 310, 812, 325);
		tab1.add(scrollpane);

		// *********************FILL_DIARY*********************************

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(889, 310, 58, 54);
		tab1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");

		btnNewButton_1.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/pencil.png")));
		btnNewButton_1.setBounds(889, 375, 58, 51);
		tab1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/settings.png")));
		btnNewButton_2.setBounds(889, 437, 58, 51);
		tab1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/search.png")));
		btnNewButton_3.setBounds(889, 499, 58, 46);
		tab1.add(btnNewButton_3);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/delete.png")));
		button.setBounds(889, 560, 58, 51);
		tab1.add(button);

		JPanel tab2 = new JPanel();
		tab2.setBackground(new Color(0, 255, 255));
		tab2.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab2.setLayout(null);
		tabbedPane.addTab("Patients", tab2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/receptionist.png")));
		lblNewLabel_1.setBounds(1133, 11, 203, 249);
		tab2.add(lblNewLabel_1);

		JLabel lblPatientRecords = new JLabel("Patient Records");
		lblPatientRecords.setForeground(new Color(0, 0, 51));
		lblPatientRecords.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPatientRecords.setBounds(569, 11, 237, 46);
		tab2.add(lblPatientRecords);
		// *********************FILL_PATIENTS*********************************
		patientsEntry = look_up.fillPatients();
		patientstableModel = new DefaultTableModel(patientsEntry,
				patientsColumns);
		patientsTable = new JTable(patientstableModel);
		patientsTable.setBounds(64, 325, 1204, 325);
		patientsTable.getTableHeader().setBackground(Color.pink);
		patientsTable.getTableHeader().setForeground(Color.blue);
		patientsTable.getTableHeader().setFont(tf);
		patientsscrollpane = new JScrollPane(patientsTable);
		patientsscrollpane.setBounds(64, 325, 1204, 325);
		tab2.add(patientsscrollpane);

		// *********************FILL_DIARY*********************************
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		myPanel.add(new JLabel("ID:"));
		myPanel.add(id);
		myPanel.add(new JLabel("Name:"));
		myPanel.add(name);
		myPanel.add(new JLabel("Surname:"));
		myPanel.add(surname);
		myPanel.add(new JLabel("Email:"));
		myPanel.add(email);
		myPanel.add(new JLabel("Address:"));
		myPanel.add(address);
		myPanel.add(new JLabel("Telephone:"));
		myPanel.add(telephone);
		myPanel.add(new JLabel("Birthday:"));
		myPanel.add(birthday);
		myPanel.add(new JLabel("Gender:"));
		myPanel.add(gender);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						"Add new patient information",
						JOptionPane.OK_CANCEL_OPTION, 0,
						new ImageIcon(Receptionist_GUI.class
								.getResource("/img/add.png")));

				if (result == JOptionPane.OK_OPTION) {
					int ID = Integer.parseInt(id.getText());
					String Name = name.getText();
					String Surname = surname.getText();
					String Email = email.getText();
					String Address = address.getText();
					String tel = telephone.getText();
					String bday = birthday.getText();
					String Gender = gender.getText();

					try {
						look_up.addPatient(ID, Name, Surname, Email, Address,
								bday, tel, Gender);
					} catch (RemoteException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					patientstableModel.addRow(new Object[] { ID, Name, Surname,
							Email, Address, bday, tel, Gender });
					patientstableModel.fireTableDataChanged();
				}
			}
		});
		button_1.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/add.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_1.setBounds(1278, 325, 58, 54);
		tab2.add(button_1);

		JButton btnNewButton_4 = new JButton("");
//		btnNewButton_4.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				patientsEntry = null;
//				try {
//					patientsEntry = look_up.fillPatients();
//				} catch (RemoteException | SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//				patientstableModel = new DefaultTableModel(patientsEntry,
//						patientsColumns);
//				patientsTable = new JTable(patientstableModel);
//				patientsTable.setBounds(64, 325, 1204, 325);
//				patientsTable.getTableHeader().setBackground(Color.pink);
//				patientsTable.getTableHeader().setForeground(Color.blue);
//				patientsTable.getTableHeader().setFont(tf);
//				patientsscrollpane = new JScrollPane(patientsTable);
//				patientsscrollpane.setBounds(64, 325, 1204, 325);
//				tab2.add(patientsscrollpane);
//			}
//		});
		btnNewButton_4.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/refresh.png")));
		btnNewButton_4.setBounds(1280, 415, 58, 54);
		tab2.add(btnNewButton_4);
		btnNewButton_4.setEnabled(false);
		JButton button_2 = new JButton("");

		button_2.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/pencil.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_2.setBounds(1278, 503, 58, 54);
		tab2.add(button_2);

		JButton button_3 = new JButton("");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = patientsTable.getSelectedRow();
				if (row >= 0) {
					Object id = patientstableModel.getValueAt(row, 0);
					try {
						look_up.deletePatient(id);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					patientstableModel.removeRow(row);
					patientstableModel.fireTableDataChanged();
				}
			}
		});
		button_3.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/delete.png")));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_3.setBounds(1278, 596, 58, 54);
		tab2.add(button_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/patient.png")));
		lblNewLabel_4.setBounds(10, 11, 237, 234);
		tab2.add(lblNewLabel_4);
		setVisible(true);
	}
}
