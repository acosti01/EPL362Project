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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.rmi.RemoteException;
import java.sql.SQLException;
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
	JPanel myPanel4 = new JPanel();
	JPanel myPanel5 = new JPanel();
	JPanel myPanel6 = new JPanel();
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
	JTextField patientsname2 = new JTextField(20);
	JTextField patientssurname2 = new JTextField(20);
	JTextField patientstelephone2 = new JTextField(20);
	JTextField patientsid3 = new JTextField(8);
	JTextField cliniciansname2 = new JTextField(20);
	JTextField clinicianssurname2 = new JTextField(20);
	JTextField clinicname = new JTextField(20);
	JTextField appointmenttime2 = new JTextField(20);
	JTextField appointmenttype = new JTextField(20);
	JTextField appointmenttype1 = new JTextField(20);
	JTextField appointmentid1 = new JTextField(8);
	JTextField appointmentdate1 = new JTextField(20);
	JTextField appointmenttime1 = new JTextField(20);
	JComboBox<String> typeComboBox1 = new JComboBox<String>();
	JComboBox<String> statusComboBox1 = new JComboBox<String>();
	JTextField cliniciansname1 = new JTextField(20);
	JComboBox<String> cliniciansComboBox1 = new JComboBox<String>();
	JComboBox<String> clinicsComboBox1 = new JComboBox<String>();
	Object[][] patientsEntry;
	String[] patientsColumns = { "ID", "Name", "Surname", "Email", "Address",
			"Phone Number", "Birthday", "Gender" };

	DefaultTableModel patientstableModel;
	DefaultTableModel diarytableModel;

	JTable diaryTable;
	JTable patientsTable;
	JScrollPane diaryscrollpane;
	JScrollPane patientsscrollpane;
	private JTextField textField;

	JTextField appointmentid2 = new JTextField();
	JTextField patientsid4 = new JTextField();
	JTextField clinicIDforView = new JTextField();
	JTextField clinicianIDforView = new JTextField();
	JTextField appointmentdate2 = new JTextField();
	JTextField appointmenttime3 = new JTextField();
	JTextField type1 = new JTextField();
	JTextField status = new JTextField();
	private JTextField textField_1;

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
		lblNewLabel.setBounds(1133, 6, 215, 256);
		tab1.add(lblNewLabel);
		tab1.setBackground(new Color(100, 149, 237));

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
		String[] diaryColumns = { "Appointment ID", "Patients ID", "Name",
				"Surname", "Phone Number", "Date", "Dr. Name", "Dr. Surname",
				"Clinic", "Time", "Type" };
		DefaultTableModel diarytableModel = new DefaultTableModel(diaryEntry,
				diaryColumns);
		diaryTable = new JTable(diarytableModel);
		diaryTable.setBounds(57, 310, 1204, 325);
		diaryTable.getTableHeader().setBackground(Color.pink);
		diaryTable.getTableHeader().setForeground(Color.blue);
		Font tf = new Font("Appointments", Font.BOLD, 12);
		diaryTable.getTableHeader().setFont(tf);
		JScrollPane scrollpane = new JScrollPane(diaryTable);
		scrollpane.setBounds(57, 274, 1180, 325);
		tab1.add(scrollpane);

		// ************************************************************

		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, myPanel3,
						"Add new appointment", JOptionPane.OK_CANCEL_OPTION, 0,
						new ImageIcon(Receptionist_GUI.class
								.getResource("/img/add.png")));

				if (result == JOptionPane.OK_OPTION) {
					int appID = 0;
					int patientsID = Integer.parseInt(patientsid2.getText());
					String date = appointmentdate.getText();
					String time = appointmenttime.getText();
					String clinic = clinicsComboBox.getSelectedItem()
							.toString();
					String clinician = cliniciansComboBox.getSelectedItem()
							.toString();
					String type = typeComboBox.getSelectedItem().toString();
					String status = statusComboBox.getSelectedItem().toString();
					String fullname = null;
					try {
						fullname = look_up.getPatientsFullName(patientsID);
					} catch (RemoteException | SQLException e2) {
						e2.printStackTrace();
					}
					String[] splited = fullname.split("\\s+");
					String name = splited[0];
					String surname = splited[1];
					String phone = splited[2];
					String[] splited1 = clinician.split("\\s+");
					String clinicianName = splited1[0];
					String clinicianSurname = splited1[1];
					try {
						appID = look_up.addAppointment(patientsID, date, time,
								clinic, clinician, type, status);
					} catch (RemoteException | SQLException e1) {
						e1.printStackTrace();
					}
					diarytableModel.addRow(new Object[] { appID, patientsID,
							name, surname, phone, date, clinicianName,
							clinicianSurname, clinic, time, type });
					diarytableModel.fireTableDataChanged();
				}
			}
		});

		btnNewButton.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(1249, 274, 58, 54);
		tab1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = diaryTable.getSelectedRow();

				if (row >= 0) {
					appointmentid1.setText(
							diarytableModel.getValueAt(row, 0).toString());
					patientsid3.setText(
							diarytableModel.getValueAt(row, 1).toString());
					patientsname2.setText(
							(String) diarytableModel.getValueAt(row, 2));
					patientssurname2.setText(
							(String) diarytableModel.getValueAt(row, 3));
					patientstelephone2.setText(
							(String) diarytableModel.getValueAt(row, 4));
					appointmentdate1.setText(
							(String) diarytableModel.getValueAt(row, 5));
					cliniciansname2.setText(
							(String) diarytableModel.getValueAt(row, 6));
					clinicianssurname2.setText(
							(String) diarytableModel.getValueAt(row, 7));
					clinicname.setText(
							(String) diarytableModel.getValueAt(row, 8));
					appointmenttime2.setText(
							(String) diarytableModel.getValueAt(row, 9));
					int result = JOptionPane.showConfirmDialog(null, myPanel4,
							"Edit patient information",
							JOptionPane.OK_CANCEL_OPTION, 0,
							new ImageIcon(Receptionist_GUI.class
									.getResource("/img/pencil.png")));

					if (result == JOptionPane.OK_OPTION) {
						int ID = Integer.parseInt(appointmentid1.getText());
						int patientsID = Integer
								.parseInt(patientsid3.getText());
						String date = appointmentdate1.getText();
						int clinicianID = 0;
						try {
							clinicianID = look_up.getClinicianID(
									cliniciansname2.getText(),
									clinicianssurname2.getText());
						} catch (RemoteException | SQLException e1) {
							e1.printStackTrace();
						}
						String Name = patientsname2.getText();
						String Surname = patientssurname2.getText();
						String Telephone = patientstelephone2.getText();
						String Clinician_name = cliniciansname2.getText();
						String Clinician_surname = clinicianssurname2.getText();
						String Clinic = clinicsComboBox1.getSelectedItem()
								.toString();
						String Time = appointmenttime2.getText();
						String Type = typeComboBox1.getSelectedItem()
								.toString();

						try {
							look_up.editAppointment(ID, date, patientsID,
									clinicianID, Clinic, Time, Type);
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
						diarytableModel.removeRow(row);
						diarytableModel.addRow(new Object[] { ID, patientsID,
								Name, Surname, Telephone, date, Clinician_name,
								Clinician_surname, Clinic, Time, Type });
						diarytableModel.fireTableDataChanged();
					}
				}
			}
		});

		btnNewButton_1.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/pencil.png")));
		btnNewButton_1.setBounds(1249, 353, 58, 51);
		tab1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/settings.png")));
		btnNewButton_2.setBounds(1249, 442, 58, 51);
		tab1.add(btnNewButton_2);

		myPanel5.setLayout(new BoxLayout(myPanel5, BoxLayout.Y_AXIS));
		myPanel5.add(new JLabel("Appointment ID:"));
		myPanel5.add(appointmentid2);
		appointmentid2.setEnabled(false);
		myPanel5.add(new JLabel("Patients ID:"));
		myPanel5.add(patientsid4);
		patientsid4.setEnabled(false);
		myPanel5.add(new JLabel("Clinic:"));
		myPanel5.add(clinicIDforView);
		clinicIDforView.setEnabled(false);
		myPanel5.add(new JLabel("Clinician:"));
		myPanel5.add(clinicianIDforView);
		clinicianIDforView.setEnabled(false);
		myPanel5.add(new JLabel("Date: (YYYY-MM-DD)"));
		myPanel5.add(appointmentdate2);
		appointmentdate2.setEnabled(false);
		myPanel5.add(new JLabel("Time: (HH:MM:SS)"));
		myPanel5.add(appointmenttime3);
		appointmenttime3.setEnabled(false);
		myPanel5.add(new JLabel("Type:"));
		myPanel5.add(type1);
		type1.setEnabled(false);
		myPanel5.add(new JLabel("Status:"));
		myPanel5.add(status);
		status.setEnabled(false);

		JLabel lblNoResultsFound = new JLabel("No results found!");
		lblNoResultsFound.setForeground(new Color(0, 0, 51));
		lblNoResultsFound.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNoResultsFound.setBounds(975, 669, 262, 46);
		tab1.add(lblNoResultsFound);
		lblNoResultsFound.setVisible(false);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int id = Integer.parseInt(textField.getText());

				String result = null;
				try {
					result = look_up.findAppointment(id);
				} catch (RemoteException | SQLException e1) {
					e1.printStackTrace();
				}
				if (result != null) {
					lblNoResultsFound.setVisible(false);
					String[] splited = result.split(" ");
					appointmentid2.setText(splited[0]);
					appointmentdate2.setText(splited[1]);
					patientsid4.setText(splited[2]);
					clinicianIDforView.setText(splited[3]);
					clinicIDforView.setText(splited[4]);
					appointmenttime3.setText(splited[5]);
					type1.setText(splited[6]);
					status.setText(splited[7]);
					JOptionPane.showConfirmDialog(null, myPanel5, "View result",
							JOptionPane.OK_CANCEL_OPTION, 0,
							new ImageIcon(Receptionist_GUI.class
									.getResource("/img/search.png")));
				} else {
					lblNoResultsFound.setVisible(true);
				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/search.png")));
		btnNewButton_3.setBounds(1249, 611, 58, 46);
		tab1.add(btnNewButton_3);

		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// delete button apt

				int row = diaryTable.getSelectedRow();
				if (row >= 0) {
					Object id = diarytableModel.getValueAt(row, 0);
					try {
						look_up.deleteAppointment(id);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					diarytableModel.removeRow(row);
					diarytableModel.fireTableDataChanged();
				}
			}
		});
		button.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/delete.png")));
		button.setBounds(1249, 525, 58, 51);
		tab1.add(button);

		JLabel lblSearchByPatients = new JLabel("Search by Patients ID:");
		lblSearchByPatients.setForeground(new Color(0, 0, 51));
		lblSearchByPatients.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSearchByPatients.setBounds(725, 611, 262, 46);
		tab1.add(lblSearchByPatients);

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		textField.setBounds(999, 611, 238, 40);
		tab1.add(textField);
		textField.setColumns(10);

		JPanel tab2 = new JPanel();
		tab2.setBackground(new Color(100, 149, 237));
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
		patientsscrollpane.setBounds(64, 303, 1204, 325);
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

		}
		myPanel3.add(clinicsComboBox);
		myPanel3.add(new JLabel("Clinician:"));
		Object[] clinicians = look_up.getClinicians();
		if (clinicians == null)
			System.out.println("null");
		else {
			for (int i = 0; i < clinicians.length; i++)
				cliniciansComboBox.addItem((clinicians[i]).toString());
		}
		myPanel3.add(cliniciansComboBox);

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

		// *******************************************************

		// *************** panel for edit appointment ************
		myPanel4.setLayout(new BoxLayout(myPanel4, BoxLayout.Y_AXIS));
		myPanel4.add(new JLabel("Appointment ID:"));
		myPanel4.add(appointmentid1);
		appointmentid1.setEnabled(false);

		myPanel4.add(new JLabel("Appointment Date:"));
		myPanel4.add(appointmentdate1);
		myPanel4.add(new JLabel("Appointment Time:"));
		myPanel4.add(appointmenttime2);
		myPanel4.add(new JLabel("Patients ID:"));
		myPanel4.add(patientsid3);
		myPanel4.add(new JLabel("Clinic:"));
		clinics = look_up.getClinics();
		if (clinics == null)
			System.out.println("null");
		else {
			for (int i = 0; i < clinics.length; i++)
				clinicsComboBox1.addItem((clinics[i]).toString());
			myPanel4.add(clinicsComboBox1);
		}
		clinicsComboBox1.setSelectedItem(clinicname);
		myPanel4.add(new JLabel("Clinician:"));
		clinicians = look_up.getClinicians();
		if (clinicians == null)
			System.out.println("null");
		else {
			for (int i = 0; i < clinicians.length; i++)
				cliniciansComboBox1.addItem((clinicians[i]).toString());
			myPanel4.add(cliniciansComboBox1);
		}
		cliniciansComboBox1
				.setSelectedItem(cliniciansname2 + " " + clinicianssurname2);
		myPanel4.add(new JLabel("Type:"));
		typeComboBox1.addItem("PRE_ARRANGED");
		typeComboBox1.addItem("DROP_IN");
		myPanel4.add(typeComboBox1);
		typeComboBox1.setSelectedItem(appointmenttype1);

		// *******************************************************8

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						"Add new patient information",
						JOptionPane.OK_CANCEL_OPTION, 0,
						new ImageIcon(Receptionist_GUI.class
								.getResource("/img/add.png")));

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
						look_up.addPatient(ID, Name, Surname, Email, Address,
								bday, tel, Gender);
					} catch (RemoteException | SQLException e1) {
						e1.printStackTrace();
					}

					patientstableModel.addRow(new Object[] { ID, Name, Surname,
							Email, Address, tel, bday, Gender });
					patientstableModel.fireTableDataChanged();
				}
			}
		});
		button_1.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/add.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_1.setBounds(1278, 303, 58, 54);
		tab2.add(button_1);

		JButton btnNewButton_4 = new JButton("");

		btnNewButton_4.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/refresh.png")));
		btnNewButton_4.setBounds(1278, 389, 58, 54);
		tab2.add(btnNewButton_4);
		btnNewButton_4.setEnabled(false);
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/pencil.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_2.setBounds(1280, 473, 58, 54);
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
					patientsid1.setText(
							patientstableModel.getValueAt(row, 0).toString());
					patientsid1.setEnabled(false);
					patientsname1.setText(
							(String) patientstableModel.getValueAt(row, 1));
					patientssurname1.setText(
							(String) patientstableModel.getValueAt(row, 2));
					patientsemail1.setText(
							(String) patientstableModel.getValueAt(row, 3));
					patientsaddress1.setText(
							(String) patientstableModel.getValueAt(row, 4));
					patientstelephone1.setText(
							(String) patientstableModel.getValueAt(row, 5));
					patientsbirthday1.setText(
							(String) patientstableModel.getValueAt(row, 6));
					patientsgender1.setText(
							(String) patientstableModel.getValueAt(row, 7));
					patientsgender1.setEnabled(false);

					int result = JOptionPane.showConfirmDialog(null, myPanel1,
							"Edit patient information",
							JOptionPane.OK_CANCEL_OPTION, 0,
							new ImageIcon(Receptionist_GUI.class
									.getResource("/img/pencil.png")));

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
							look_up.editPatient(ID, Name, Surname, Email,
									Address, bday, tel, Gender);
							patientstableModel.removeRow(row);
							patientstableModel.addRow(
									new Object[] { ID, Name, Surname, Email,
											Address, tel, bday, Gender });
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
		button_3.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/delete.png")));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_3.setBounds(1280, 561, 58, 54);
		tab2.add(button_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/patient.png")));
		lblNewLabel_4.setBounds(10, 11, 237, 234);
		tab2.add(lblNewLabel_4);

		JLabel lblSearchByPatiend = new JLabel("Search by Patient ID:");
		lblSearchByPatiend.setForeground(new Color(0, 0, 51));
		lblSearchByPatiend.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSearchByPatiend.setBounds(814, 629, 250, 46);
		tab2.add(lblSearchByPatiend);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		textField_1.setBounds(1076, 640, 192, 26);
		tab2.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNoResultsFound_1 = new JLabel("No results found!");
		lblNoResultsFound_1.setForeground(new Color(0, 0, 51));
		lblNoResultsFound_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNoResultsFound_1.setBounds(1031, 671, 237, 46);
		tab2.add(lblNoResultsFound_1);
		lblNoResultsFound_1.setVisible(false);

		JTextField patientsid16 = new JTextField();
		JTextField patientsname16 = new JTextField();
		JTextField patientssurname16 = new JTextField();
		JTextField patientsemail16 = new JTextField();
		JTextField patientsaddress16 = new JTextField();
		JTextField patientstelephone16 = new JTextField();
		JTextField patientsbirthday16 = new JTextField();
		JTextField patientsgender16 = new JTextField();

		myPanel6.setLayout(new BoxLayout(myPanel6, BoxLayout.Y_AXIS));
		myPanel6.add(new JLabel("ID:"));
		myPanel6.add(patientsid16);
		patientsid16.setEnabled(false);
		myPanel6.add(new JLabel("Name:"));
		myPanel6.add(patientsname16);
		patientsname16.setEnabled(false);
		myPanel6.add(new JLabel("Surname:"));
		myPanel6.add(patientssurname16);
		patientssurname16.setEnabled(false);
		myPanel6.add(new JLabel("Email:"));
		myPanel6.add(patientsemail16);
		patientsemail16.setEnabled(false);
		myPanel6.add(new JLabel("Address:"));
		myPanel6.add(patientsaddress16);
		patientsaddress16.setEnabled(false);
		myPanel6.add(new JLabel("Telephone:"));
		myPanel6.add(patientstelephone16);
		patientstelephone16.setEnabled(false);
		myPanel6.add(new JLabel("Birthday:"));
		myPanel6.add(patientsbirthday16);
		patientsbirthday16.setEnabled(false);
		myPanel6.add(new JLabel("Gender:"));
		myPanel6.add(patientsgender16);
		patientsgender16.setEnabled(false);

		JButton button_4 = new JButton("");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int id = Integer.parseInt(textField_1.getText());

				String result = null;
				try {
					result = look_up.findPatient(id);
				} catch (RemoteException | SQLException e1) {
					e1.printStackTrace();
				}
				if (result != null) {
					lblNoResultsFound_1.setVisible(false);
					String[] splited = result.split("/");
					patientsid16.setText(splited[0]);
					patientsname16.setText(splited[1]);
					patientssurname16.setText(splited[2]);
					patientsemail16.setText(splited[3]);
					patientsaddress16.setText(splited[4]);
					patientstelephone16.setText(splited[5]);
					patientsbirthday16.setText(splited[6]);
					patientsgender16.setText(splited[7]);
					JOptionPane.showConfirmDialog(null, myPanel6,
							"View patient", JOptionPane.OK_CANCEL_OPTION, 0,
							new ImageIcon(Receptionist_GUI.class
									.getResource("/img/search.png")));
				} else {
					lblNoResultsFound_1.setVisible(true);
				}
			}
		});
		button_4.setIcon(new ImageIcon(
				Receptionist_GUI.class.getResource("/img/search.png")));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_4.setBounds(1278, 635, 58, 54);
		tab2.add(button_4);
		setVisible(true);
	}
}