package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Entities.User;
import javafx.scene.control.ComboBox;
import rmiinterface.RMIInterface;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Receptionist_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel myPanel = new JPanel();
	JPanel myPanel1 = new JPanel();
	JPanel myPanel2 = new JPanel();
	JPanel myPanel3 = new JPanel();
	JTextField patientsid = new JTextField(20);
	JTextField patientsname = new JTextField(20);
	JTextField patientssurname = new JTextField(20);
	JTextField patientsemail = new JTextField(20);
	JTextField patientsaddress = new JTextField(20);
	JTextField patientstelephone = new JTextField(20);
	JTextField patientsbirthday = new JTextField(20);
	JTextField patientsgender = new JTextField(20);
	JTextField patientsid1 = new JTextField(20);
	JTextField patientsname1 = new JTextField(20);
	JTextField patientssurname1 = new JTextField(20);
	JTextField patientsemail1 = new JTextField(20);
	JTextField patientsaddress1 = new JTextField(20);
	JTextField patientstelephone1 = new JTextField(20);
	JTextField patientsbirthday1 = new JTextField(20);
	JTextField patientsgender1 = new JTextField(20);
	JTextField cliniciansname = new JTextField(20);
	JComboBox<String> cliniciansComboBox = new JComboBox<String>();
	JComboBox<String> clinicsComboBox = new JComboBox<String>();
	JTextField patientsid2 = new JTextField(8);
	JTextField appointmentid = new JTextField(8);
	JTextField appointmentdate = new JTextField(20);
	JTextField appointmenttime = new JTextField(20);
	JComboBox<String> typeComboBox = new JComboBox<String>();
	JComboBox<String> statusComboBox = new JComboBox<String>();

	Object[][] patientsEntry;
	String[] patientsColumns = { "ID", "Name", "Surname", "Email", "Address", "Phone Number", "Birthday", "Gender" };
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
	public Receptionist_GUI(User user, RMIInterface look_up) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException, SQLException, RemoteException {
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
		lblNewLabel.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/receptionist.png")));
		lblNewLabel.setBounds(811, 0, 215, 256);
		tab1.add(lblNewLabel);
		tab1.setBackground(new Color(0, 255, 255));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/diary.png")));
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
		String[] diaryColumns = { "ID", "Name", "Surname", "Phone Number", "Date", "Clinicians First Name",
				"Clinicians Last Name", "Clinic", "Time", "Type" };
		DefaultTableModel diarytableModel = new DefaultTableModel(diaryEntry, diaryColumns);
		JTable diaryTable = new JTable(diarytableModel);
		diaryTable.setBounds(57, 310, 812, 325);
		diaryTable.getTableHeader().setBackground(Color.pink);
		diaryTable.getTableHeader().setForeground(Color.blue);
		Font tf = new Font("Appointments", Font.BOLD, 12);
		diaryTable.getTableHeader().setFont(tf);
		JScrollPane scrollpane = new JScrollPane(diaryTable);
		scrollpane.setBounds(57, 310, 812, 325);
		tab1.add(scrollpane);

		// ************************************************************

		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, myPanel3, "Add new appointment",
						JOptionPane.OK_CANCEL_OPTION, 0,
						new ImageIcon(Receptionist_GUI.class.getResource("/img/add.png")));

				if (result == JOptionPane.OK_OPTION) {

					int ID = Integer.parseInt(appointmentid.getText());
					int patientsID = Integer.parseInt(patientsid2.getText());
					String date = appointmentdate.getText();
					String time = appointmenttime.getText();
					String clinic = clinicsComboBox.getSelectedItem().toString();
					String clinician = cliniciansComboBox.getSelectedItem().toString();
					String type = typeComboBox.getSelectedItem().toString();
					String status = statusComboBox.getSelectedItem().toString();

					try {
						look_up.addAppointment(ID, patientsID, date, time, clinic, clinician, type, status);
					} catch (RemoteException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnNewButton.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(889, 310, 58, 54);
		tab1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");

		btnNewButton_1.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/pencil.png")));
		btnNewButton_1.setBounds(889, 375, 58, 51);
		tab1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/settings.png")));
		btnNewButton_2.setBounds(889, 437, 58, 51);
		tab1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/search.png")));
		btnNewButton_3.setBounds(889, 499, 58, 46);
		tab1.add(btnNewButton_3);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/delete.png")));
		button.setBounds(889, 560, 58, 51);
		tab1.add(button);

		JPanel tab2 = new JPanel();
		tab2.setBackground(new Color(0, 255, 255));
		tab2.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab2.setLayout(null);
		tabbedPane.addTab("Patients", tab2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/receptionist.png")));
		lblNewLabel_1.setBounds(1133, 11, 203, 249);
		tab2.add(lblNewLabel_1);

		JLabel lblPatientRecords = new JLabel("Patient Records");
		lblPatientRecords.setForeground(new Color(0, 0, 51));
		lblPatientRecords.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPatientRecords.setBounds(569, 11, 237, 46);
		tab2.add(lblPatientRecords);
		// *********************FILL_PATIENTS*********************************
		patientsEntry = look_up.fillPatients();
		patientstableModel = new DefaultTableModel(patientsEntry, patientsColumns);
		patientsTable = new JTable(patientstableModel);
		patientsTable.setBounds(64, 325, 1204, 325);
		patientsTable.getTableHeader().setBackground(Color.pink);
		patientsTable.getTableHeader().setForeground(Color.blue);
		patientsTable.getTableHeader().setFont(tf);
		patientsscrollpane = new JScrollPane(patientsTable);
		patientsscrollpane.setBounds(64, 325, 1204, 325);
		tab2.add(patientsscrollpane);

		// ********************************************************************
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		myPanel.add(new JLabel("ID:"));
		myPanel.add(patientsid);
		myPanel.add(new JLabel("Name:"));
		myPanel.add(patientsname);
		myPanel.add(new JLabel("Surname:"));
		myPanel.add(patientssurname);
		myPanel.add(new JLabel("Email:"));
		myPanel.add(patientsemail);
		myPanel.add(new JLabel("Address:"));
		myPanel.add(patientsaddress);
		myPanel.add(new JLabel("Telephone:"));
		myPanel.add(patientstelephone);
		myPanel.add(new JLabel("Birthday:"));
		myPanel.add(patientsbirthday);
		myPanel.add(new JLabel("Gender:"));
		myPanel.add(patientsgender);

		// *************** panel for add appointment ************
		myPanel3.setLayout(new BoxLayout(myPanel3, BoxLayout.Y_AXIS));
		myPanel3.add(new JLabel("Appointment ID:"));
		myPanel3.add(appointmentid);
		myPanel3.add(new JLabel("Patients ID:"));
		myPanel3.add(patientsid2);

		myPanel3.add(new JLabel("Clinic:"));
		Object[] clinics = look_up.getClinics();
		if (clinics == null)
			System.out.println("null");
		else {
			for (int i = 0; i < clinics.length; i++)
				clinicsComboBox.addItem((clinics[i]).toString());
			myPanel3.add(clinicsComboBox);
		}

		myPanel3.add(new JLabel("Clinician:"));
		Object[] clinicians = look_up.getClinicians();
		if (clinicians == null)
			System.out.println("null");
		else {
			for (int i = 0; i < clinicians.length; i++)
				cliniciansComboBox.addItem((clinicians[i]).toString());
			myPanel3.add(cliniciansComboBox);
		}

		myPanel3.add(new JLabel("Date: (YYYY-MM-DD)"));
		myPanel3.add(appointmentdate);
		myPanel3.add(new JLabel("Time: (HH:MM:SS)"));
		myPanel3.add(appointmenttime);
		myPanel3.add(new JLabel("Type:"));
		typeComboBox.addItem("PRE_ARRANGED");
		typeComboBox.addItem("DROP_IN");
		myPanel3.add(typeComboBox);
		myPanel3.add(new JLabel("Status:"));
		statusComboBox.addItem("SHOW_UP");
		statusComboBox.addItem("NOT_SHOW_UP");
		myPanel3.add(statusComboBox);

		// *******************************************************8

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, myPanel, "Add new patient information",
						JOptionPane.OK_CANCEL_OPTION, 0,
						new ImageIcon(Receptionist_GUI.class.getResource("/img/add.png")));

				if (result == JOptionPane.OK_OPTION) {
					int ID = Integer.parseInt(patientsid.getText());
					String Name = patientsname.getText();
					String Surname = patientssurname.getText();
					String Email = patientsemail.getText();
					String Address = patientsaddress.getText();
					String tel = patientstelephone.getText();
					String bday = patientsbirthday.getText();
					String Gender = patientsgender.getText();

					try {
						look_up.addPatient(ID, Name, Surname, Email, Address, bday, tel, Gender);
					} catch (RemoteException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					patientstableModel.addRow(new Object[] { ID, Name, Surname, Email, Address, bday, tel, Gender });
					patientstableModel.fireTableDataChanged();
				}
			}
		});
		button_1.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/add.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_1.setBounds(1278, 325, 58, 54);
		tab2.add(button_1);

		JButton btnNewButton_4 = new JButton("");
		// btnNewButton_4.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent e) {
		//
		// patientsEntry = null;
		// try {
		// patientsEntry = look_up.fillPatients();
		// } catch (RemoteException | SQLException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// patientstableModel = new DefaultTableModel(patientsEntry,
		// patientsColumns);
		// patientsTable = new JTable(patientstableModel);
		// patientsTable.setBounds(64, 325, 1204, 325);
		// patientsTable.getTableHeader().setBackground(Color.pink);
		// patientsTable.getTableHeader().setForeground(Color.blue);
		// patientsTable.getTableHeader().setFont(tf);
		// patientsscrollpane = new JScrollPane(patientsTable);
		// patientsscrollpane.setBounds(64, 325, 1204, 325);
		// tab2.add(patientsscrollpane);
		// }
		// });
		btnNewButton_4.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/refresh.png")));
		btnNewButton_4.setBounds(1280, 415, 58, 54);
		tab2.add(btnNewButton_4);
		btnNewButton_4.setEnabled(false);
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/pencil.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_2.setBounds(1278, 503, 58, 54);
		tab2.add(button_2);

		myPanel1.setLayout(new BoxLayout(myPanel1, BoxLayout.Y_AXIS));
		myPanel1.add(new JLabel("ID:"));
		myPanel1.add(patientsid1);
		myPanel1.add(new JLabel("Name:"));
		myPanel1.add(patientsname1);
		myPanel1.add(new JLabel("Surname:"));
		myPanel1.add(patientssurname1);
		myPanel1.add(new JLabel("Email:"));
		myPanel1.add(patientsemail1);
		myPanel1.add(new JLabel("Address:"));
		myPanel1.add(patientsaddress1);
		myPanel1.add(new JLabel("Telephone:"));
		myPanel1.add(patientstelephone1);
		myPanel1.add(new JLabel("Birthday:"));
		myPanel1.add(patientsbirthday1);
		myPanel1.add(new JLabel("Gender:"));
		myPanel1.add(patientsgender1);

		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = patientsTable.getSelectedRow();

				if (row >= 0) {
					patientsid1.setText((String) patientstableModel.getValueAt(row, 0));
					patientsid1.setEditable(false);
					patientsname1.setText((String) patientstableModel.getValueAt(row, 1));
					patientssurname1.setText((String) patientstableModel.getValueAt(row, 2));
					patientsemail1.setText((String) patientstableModel.getValueAt(row, 3));
					patientsaddress1.setText((String) patientstableModel.getValueAt(row, 4));
					patientstelephone1.setText((String) patientstableModel.getValueAt(row, 5));
					patientsbirthday1.setText((String) patientstableModel.getValueAt(row, 6));
					patientsgender1.setText((String) patientstableModel.getValueAt(row, 7));
					patientsgender1.setEditable(false);

					int result = JOptionPane.showConfirmDialog(null, myPanel1, "Edit patient information",
							JOptionPane.OK_CANCEL_OPTION, 0,
							new ImageIcon(Receptionist_GUI.class.getResource("/img/pencil.png")));

					if (result == JOptionPane.OK_OPTION) {
						int ID = Integer.parseInt(patientsid1.getText());
						String Name = patientsname1.getText();
						String Surname = patientssurname1.getText();
						String Email = patientsemail1.getText();
						String Address = patientsaddress1.getText();
						String tel = patientstelephone1.getText();
						String bday = patientsbirthday1.getText();
						String Gender = patientsgender1.getText();

						try {
							look_up.editPatient(ID, Name, Surname, Email, Address, bday, tel, Gender);
							patientstableModel.removeRow(row);
							patientstableModel
									.addRow(new Object[] { ID, Name, Surname, Email, Address, bday, tel, Gender });
							patientstableModel.fireTableDataChanged();
						} catch (RemoteException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});

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
		button_3.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/delete.png")));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_3.setBounds(1278, 596, 58, 54);
		tab2.add(button_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/patient.png")));
		lblNewLabel_4.setBounds(10, 11, 237, 234);
		tab2.add(lblNewLabel_4);
		setVisible(true);
	}
}