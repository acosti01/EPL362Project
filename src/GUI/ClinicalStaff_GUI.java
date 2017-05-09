package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entities.User;
import rmiinterface.RMIInterface;

import java.awt.Font;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClinicalStaff_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab4;
	private JTextField textField;
	private JPanel MyPanel1 = new JPanel();
	private JPanel MyPanel2 = new JPanel();

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public ClinicalStaff_GUI(User user, RMIInterface look_up)
			throws RemoteException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JTabbedPane tabbedPane = new JTabbedPane();
		setContentPane(tabbedPane);
		/**********************************************************************/

		tab1 = new JPanel();
		tab1.setBackground(new Color(100, 149, 237));
		tab1.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab1.setLayout(null);
		tabbedPane.addTab("Diagnose", tab1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				ClinicalStaff_GUI.class.getResource("/img/diagnose.png")));
		label.setBounds(47, 38, 265, 256);
		tab1.add(label);

		JLabel lblNewLabel = new JLabel("Diagnose");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		lblNewLabel.setBounds(324, 38, 244, 42);
		tab1.add(lblNewLabel);

		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblPatientId.setBounds(47, 320, 131, 42);
		tab1.add(lblPatientId);

		JLabel lblIncidentStatus = new JLabel("Incident Status:");
		lblIncidentStatus.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblIncidentStatus.setBounds(47, 374, 196, 42);
		tab1.add(lblIncidentStatus);

		JLabel lblIncidentDetails = new JLabel("Incident Details:");
		lblIncidentDetails.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblIncidentDetails.setBounds(47, 428, 207, 42);
		tab1.add(lblIncidentDetails);

		JLabel lblRiskIndicator = new JLabel("Risk Indicator:");
		lblRiskIndicator.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblRiskIndicator.setBounds(47, 508, 183, 42);
		tab1.add(lblRiskIndicator);

		JLabel lblComments = new JLabel("Comments:");
		lblComments.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblComments.setBounds(47, 562, 143, 42);
		tab1.add(lblComments);

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		textField.setBounds(287, 320, 183, 40);
		tab1.add(textField);
		textField.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Accidental", "Dellberated" }));
		comboBox.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		comboBox.setBounds(287, 374, 183, 42);
		tab1.add(comboBox);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(
				new String[] { "DANGEROUS", "NOT DANGEROUS" }));
		comboBox_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		comboBox_1.setBounds(287, 508, 183, 42);
		tab1.add(comboBox_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(287, 426, 320, 70);
		tab1.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(287, 549, 320, 70);
		tab1.add(textArea_1);

		JLabel lblPossibleTreatments = new JLabel("Possible treatments");
		lblPossibleTreatments.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblPossibleTreatments.setBounds(745, 68, 292, 42);
		tab1.add(lblPossibleTreatments);

		JLabel lblCurrentTreatment = new JLabel("Current treatment");
		lblCurrentTreatment.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblCurrentTreatment.setBounds(745, 443, 292, 42);
		tab1.add(lblCurrentTreatment);

		JButton btnNewButton = new JButton("Complete diagnose");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNewButton.setBounds(1195, 829, 207, 42);
		tab1.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnCancel.setBounds(1068, 829, 131, 42);
		tab1.add(btnCancel);

		Object[][] possibleTreatments;
		possibleTreatments = look_up.fillDiary();
		String[] possibleTreatmentsCols = { "Condition", "Medicine",
				"Quantity" };
		DefaultTableModel treatmentModel = new DefaultTableModel(
				possibleTreatments, possibleTreatmentsCols);
		JTable possibleTreatmentsTable = new JTable(treatmentModel);
		possibleTreatmentsTable.setBounds(57, 310, 812, 325);
		possibleTreatmentsTable.getTableHeader().setBackground(Color.pink);
		possibleTreatmentsTable.getTableHeader().setForeground(Color.blue);

		Font tf = new Font("Treatments", Font.BOLD, 12);
		possibleTreatmentsTable.getTableHeader().setFont(tf);
		JScrollPane scrollpane = new JScrollPane(possibleTreatmentsTable);
		scrollpane.setBounds(739, 481, 812, 325);
		tab1.add(scrollpane);

		Object[][] currentTreatments;
		currentTreatments = look_up.fillDiary();
		DefaultTableModel currentTreatmentsModel = new DefaultTableModel(
				currentTreatments, possibleTreatmentsCols);
		JTable currentTreatmentsTable = new JTable(currentTreatmentsModel);
		currentTreatmentsTable.setBounds(57, 310, 812, 325);
		currentTreatmentsTable.getTableHeader().setBackground(Color.pink);
		currentTreatmentsTable.getTableHeader().setForeground(Color.blue);
		currentTreatmentsTable.getTableHeader().setFont(tf);
		JScrollPane scrollpane1 = new JScrollPane(currentTreatmentsTable);
		scrollpane1.setBounds(739, 110, 812, 325);
		tab1.add(scrollpane1);

		/**********************************************************************/

		tab2 = new JPanel();
		tab2.setBackground(new Color(100, 149, 237));
		tab2.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab2.setLayout(null);
		tabbedPane.addTab("Update records", tab2);

		Object[][] updateRecords;
		String[] patientCols = { "ID", "Name", "Surname", "Email", "Address",
				"Phone Number", "Birthday", "Gender" };
		updateRecords = look_up.fillPatients();
		DefaultTableModel updateRecordsModel = new DefaultTableModel(
				updateRecords, patientCols);
		JTable newTable = new JTable(updateRecordsModel);
		newTable.setBounds(57, 310, 812, 325);
		newTable.getTableHeader().setBackground(Color.pink);
		newTable.getTableHeader().setForeground(Color.blue);
		newTable.getTableHeader().setFont(tf);
		JScrollPane scrollpane1Update = new JScrollPane(newTable);
		scrollpane1Update.setBounds(73, 292, 812, 325);
		tab2.add(scrollpane1Update);

		JLabel lblUpdatedRecords = new JLabel("Update Records");
		lblUpdatedRecords.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblUpdatedRecords.setBounds(412, 213, 195, 45);
		tab2.add(lblUpdatedRecords);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				ClinicalStaff_GUI.class.getResource("/img/update.png")));
		label_1.setBounds(34, 22, 274, 236);
		tab2.add(label_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				ClinicalStaff_GUI.class.getResource("/img/doctor.png")));
		lblNewLabel_1.setBounds(1090, 51, 221, 249);
		tab2.add(lblNewLabel_1);

		JTextField patientsid1 = new JTextField();
		JTextField patientsname1 = new JTextField();
		JTextField patientssurname1 = new JTextField();
		JTextField patientsemail1 = new JTextField();
		JTextField patientsaddress1 = new JTextField();
		JTextField patientstelephone1 = new JTextField();
		JTextField patientsbirthday1 = new JTextField();
		JTextField patientsgender1 = new JTextField();

		MyPanel1.setLayout(new BoxLayout(MyPanel1, BoxLayout.Y_AXIS));
		MyPanel1.add(new JLabel("ID:"));
		MyPanel1.add(patientsid1);
		patientsid1.setEnabled(false);
		MyPanel1.add(new JLabel("Name:"));
		MyPanel1.add(patientsname1);
		MyPanel1.add(new JLabel("Surname:"));
		MyPanel1.add(patientssurname1);
		MyPanel1.add(new JLabel("Email:"));
		MyPanel1.add(patientsemail1);
		MyPanel1.add(new JLabel("Address:"));
		MyPanel1.add(patientsaddress1);
		MyPanel1.add(new JLabel("Telephone:"));
		MyPanel1.add(patientstelephone1);
		MyPanel1.add(new JLabel("Birthday:"));
		MyPanel1.add(patientsbirthday1);
		MyPanel1.add(new JLabel("Gender:"));
		MyPanel1.add(patientsgender1);
		patientsgender1.setEnabled(false);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = newTable.getSelectedRow();

				if (row >= 0) {
					patientsid1.setText(
							updateRecordsModel.getValueAt(row, 0).toString());
					patientsid1.setEnabled(false);
					patientsname1.setText(
							(String) updateRecordsModel.getValueAt(row, 1));
					patientssurname1.setText(
							(String) updateRecordsModel.getValueAt(row, 2));
					patientsemail1.setText(
							(String) updateRecordsModel.getValueAt(row, 3));
					patientsaddress1.setText(
							(String) updateRecordsModel.getValueAt(row, 4));
					patientstelephone1.setText(
							(String) updateRecordsModel.getValueAt(row, 5));
					patientsbirthday1.setText(
							(String) updateRecordsModel.getValueAt(row, 6));
					patientsgender1.setText(
							(String) updateRecordsModel.getValueAt(row, 7));
					patientsgender1.setEnabled(false);

					int result = JOptionPane.showConfirmDialog(null, MyPanel1,
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
							updateRecordsModel.removeRow(row);
							updateRecordsModel.addRow(
									new Object[] { ID, Name, Surname, Email,
											Address, tel, bday, Gender });
							updateRecordsModel.fireTableDataChanged();
						} catch (RemoteException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(
				ClinicalStaff_GUI.class.getResource("/img/pencil.png")));
		btnNewButton_1.setBounds(904, 378, 54, 52);
		tab2.add(btnNewButton_1);

		JButton button = new JButton("");

		JTextField patientsid2 = new JTextField();
		JTextField patientsname2 = new JTextField();
		JTextField patientssurname2 = new JTextField();
		JTextField patientsemail2 = new JTextField();
		JTextField patientsaddress2 = new JTextField();
		JTextField patientstelephone2 = new JTextField();
		JTextField patientsbirthday2 = new JTextField();
		JTextField patientsgender2 = new JTextField();

		MyPanel2.setLayout(new BoxLayout(MyPanel2, BoxLayout.Y_AXIS));
		MyPanel2.add(new JLabel("ID:"));
		MyPanel2.add(patientsid2);
		patientsid2.setEnabled(false);
		MyPanel2.add(new JLabel("Name:"));
		MyPanel2.add(patientsname2);
		patientsname2.setEnabled(false);
		MyPanel2.add(new JLabel("Surname:"));
		MyPanel2.add(patientssurname2);
		patientssurname2.setEnabled(false);
		MyPanel2.add(new JLabel("Email:"));
		MyPanel2.add(patientsemail2);
		patientsemail2.setEnabled(false);
		MyPanel2.add(new JLabel("Address:"));
		MyPanel2.add(patientsaddress2);
		patientsaddress2.setEnabled(false);
		MyPanel2.add(new JLabel("Telephone:"));
		MyPanel2.add(patientstelephone2);
		patientstelephone2.setEnabled(false);
		MyPanel2.add(new JLabel("Birthday:"));
		MyPanel2.add(patientsbirthday2);
		patientsbirthday2.setEnabled(false);
		MyPanel2.add(new JLabel("Gender:"));
		MyPanel2.add(patientsgender2);
		patientsgender2.setEnabled(false);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = newTable.getSelectedRow();

				if (row >= 0) {
					patientsid2.setText(
							updateRecordsModel.getValueAt(row, 0).toString());
					patientsid2.setEnabled(false);
					patientsname2.setText(
							(String) updateRecordsModel.getValueAt(row, 1));
					patientssurname2.setText(
							(String) updateRecordsModel.getValueAt(row, 2));
					patientsemail2.setText(
							(String) updateRecordsModel.getValueAt(row, 3));
					patientsaddress2.setText(
							(String) updateRecordsModel.getValueAt(row, 4));
					patientstelephone2.setText(
							(String) updateRecordsModel.getValueAt(row, 5));
					patientsbirthday2.setText(
							(String) updateRecordsModel.getValueAt(row, 6));
					patientsgender2.setText(
							(String) updateRecordsModel.getValueAt(row, 7));

					JOptionPane.showConfirmDialog(null, MyPanel2,
							"View patient information",
							JOptionPane.OK_CANCEL_OPTION, 0,
							new ImageIcon(Receptionist_GUI.class
									.getResource("/img/pencil.png")));

				}

			}
		});
		button.setIcon(new ImageIcon(
				ClinicalStaff_GUI.class.getResource("/img/view.png")));
		button.setBounds(904, 472, 54, 52);
		tab2.add(button);

		/**********************************************************************/

		tab4 = new JPanel();
		tab4.setBackground(new Color(100, 149, 237));
		tab4.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab4.setLayout(null);
		tabbedPane.addTab("Check medicines", tab4);

		/**********************************************************************/
		setVisible(true);
	}
}