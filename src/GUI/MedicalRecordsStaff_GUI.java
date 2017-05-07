package GUI;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import rmiinterface.RMIInterface;
import java.awt.Color;
import javax.swing.JTextField;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MedicalRecordsStaff_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	JPanel myPanel = new JPanel();
	JPanel myPanel1 = new JPanel();
	JTextField personnelid = new JTextField(20);
	JTextField personnelname = new JTextField(20);
	JTextField personnelsurname = new JTextField(20);
	JTextField personnelemail = new JTextField(20);
	JTextField personnelphone = new JTextField(20);
	JTextField personneluser = new JTextField(20);
	JPasswordField personnelpass = new JPasswordField(20);
	JComboBox<String> comboBoxtype = new JComboBox<String>();

	JTextField personnelid1 = new JTextField(20);
	JTextField personnelname1 = new JTextField(20);
	JTextField personnelsurname1 = new JTextField(20);
	JTextField personnelemail1 = new JTextField(20);
	JTextField personnelphone1 = new JTextField(20);
	JTextField personneluser1 = new JTextField(20);
	JPasswordField personnelpass1 = new JPasswordField(20);
	JComboBox<String> comboBoxtype1 = new JComboBox<String>();

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public MedicalRecordsStaff_GUI(RMIInterface look_up) throws RemoteException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JTabbedPane tabbedPane = new JTabbedPane();
		setLocationRelativeTo(null);
		setContentPane(tabbedPane);

		JPanel tab1 = new JPanel();
		tab1.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab1.setLayout(null);
		tabbedPane.addTab("Manage Personel", tab1);
		tab1.setBackground(new Color(100, 149, 237));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2
				.setIcon(new ImageIcon(MedicalRecordsStaff_GUI.class.getResource("/img/medical_record_staff.png")));
		lblNewLabel_2.setBounds(29, 42, 429, 246);
		tab1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Manage Personel");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setBounds(453, 227, 341, 46);
		tab1.add(lblNewLabel_3);

		Object[][] personnelEntry;
		personnelEntry = look_up.fillUser();
		String[] personnelCols = { "ID", "Name", "Surname", "Email", "Telephone", "Username", "User-type" };
		DefaultTableModel personnelTableModel = new DefaultTableModel(personnelEntry, personnelCols);
		JTable personnelTable = new JTable(personnelTableModel);
		personnelTable.setBounds(57, 310, 812, 325);
		personnelTable.getTableHeader().setBackground(Color.pink);
		personnelTable.getTableHeader().setForeground(Color.blue);
		Font tf = new Font("Personnel", Font.BOLD, 12);
		personnelTable.getTableHeader().setFont(tf);
		JScrollPane scrollpane1 = new JScrollPane(personnelTable);
		scrollpane1.setBounds(41, 325, 1215, 336);
		tab1.add(scrollpane1);

		comboBoxtype.setModel(new DefaultComboBoxModel<String>(new String[] { "RECEPTIONIST", "CLINICAL_STAFF",
				"MEDICAL_RECORD_STAFF", "HEALTH_SERVICE_MANAGEMENT" }));
		comboBoxtype.setSelectedIndex(1);

		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		myPanel.add(new JLabel("ID:"));
		myPanel.add(personnelid);
		myPanel.add(new JLabel("Name:"));
		myPanel.add(personnelname);
		myPanel.add(new JLabel("Surname:"));
		myPanel.add(personnelsurname);
		myPanel.add(new JLabel("Email:"));
		myPanel.add(personnelemail);
		myPanel.add(new JLabel("Telehone:"));
		myPanel.add(personnelphone);
		myPanel.add(new JLabel("Username:"));
		myPanel.add(personneluser);
		myPanel.add(new JLabel("Password:"));
		myPanel.add(personnelpass);
		myPanel.add(new JLabel("User-Type:"));
		myPanel.add(comboBoxtype);

		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, myPanel, "Add new staff", JOptionPane.OK_CANCEL_OPTION,
						0, new ImageIcon(Receptionist_GUI.class.getResource("/img/add.png")));

				if (result == JOptionPane.OK_OPTION) {
					int ID = Integer.parseInt(personnelid.getText());
					String Name = personnelname.getText();
					String Surname = personnelsurname.getText();
					String Email = personnelemail.getText();
					String username = personneluser.getText();
					String tel = personnelphone.getText();
					String password = personnelpass.getPassword().toString();
					String type = comboBoxtype.getSelectedItem().toString();
					try {
						look_up.addUser(ID, Name, Surname, Email, username, tel, password, type);
					} catch (RemoteException | SQLException e1) {
						e1.printStackTrace();
					}

					personnelTableModel.addRow(new Object[] { ID, Name, Surname, Email, tel, username, type });
					personnelTableModel.fireTableDataChanged();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(1278, 340, 58, 54);
		tab1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = personnelTable.getSelectedRow();

				if (row >= 0) {
					personnelid1.setText(personnelTableModel.getValueAt(row, 0).toString());
					personnelname1.setText(personnelTableModel.getValueAt(row, 1).toString());
					personnelsurname1.setText((String) personnelTableModel.getValueAt(row, 2));
					personnelemail1.setText((String) personnelTableModel.getValueAt(row, 3));
					personnelphone1.setText((String) personnelTableModel.getValueAt(row, 4));
					personneluser1.setText((String) personnelTableModel.getValueAt(row, 5));
					comboBoxtype1.setSelectedItem(personnelTableModel.getValueAt(row, 6).toString());
					int result = JOptionPane.showConfirmDialog(null, myPanel1, "Edit Staff information",
							JOptionPane.OK_CANCEL_OPTION, 0,
							new ImageIcon(Receptionist_GUI.class.getResource("/img/pencil.png")));

					if (result == JOptionPane.OK_OPTION) {
						int ID = Integer.parseInt(personnelid1.getText());
						String Name = personnelname1.getText();
						String Surname = personnelsurname1.getText();
						String Telephone = personnelphone1.getText();
						String Email = personnelemail1.getText();
						String username = personneluser1.getText();
						String password = new String(personnelpass1.getPassword());
						if (password.length() == 0) {
							try {
								password = look_up.getUserPassword(ID);
							} catch (SQLException e2) {
								e2.printStackTrace();
							} catch (RemoteException e1) {
								e1.printStackTrace();
							}
							System.out.println("password is " + password);
						}
						String Type = comboBoxtype1.getSelectedItem().toString();

						try {
							look_up.editUser(ID, Name, Surname, Telephone, Email, username, password, Type);
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
						personnelTableModel.removeRow(row);
						personnelTableModel
								.addRow(new Object[] { ID, Name, Surname, Email, Telephone, username, Type });
						personnelTableModel.fireTableDataChanged();
					}
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/pencil.png")));
		btnNewButton_1.setBounds(1278, 530, 58, 54);
		tab1.add(btnNewButton_1);

		comboBoxtype1.setModel(new DefaultComboBoxModel<String>(new String[] { "RECEPTIONIST", "CLINICAL_STAFF",
				"MEDICAL_RECORD_STAFF", "HEALTH_SERVICE_MANAGEMENT" }));
		comboBoxtype1.setSelectedIndex(1);
		myPanel1.setLayout(new BoxLayout(myPanel1, BoxLayout.Y_AXIS));
		myPanel1.add(new JLabel("ID:"));
		myPanel1.add(personnelid1);
		myPanel1.add(new JLabel("Name:"));
		myPanel1.add(personnelname1);
		myPanel1.add(new JLabel("Surname:"));
		myPanel1.add(personnelsurname1);
		myPanel1.add(new JLabel("Email:"));
		myPanel1.add(personnelemail1);
		myPanel1.add(new JLabel("Telehone:"));
		myPanel1.add(personnelphone1);
		myPanel1.add(new JLabel("Username:"));
		myPanel1.add(personneluser1);
		myPanel1.add(new JLabel("Password:"));
		myPanel1.add(personnelpass1);
		myPanel1.add(new JLabel("User-Type:"));
		myPanel1.add(comboBoxtype1);

		JButton btnNewButton_2 = new JButton("");

		btnNewButton_2.setIcon(new ImageIcon(MedicalRecordsStaff_GUI.class.getResource("/img/eyes.jpg")));
		btnNewButton_2.setBounds(1278, 435, 58, 54);
		tab1.add(btnNewButton_2);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Receptionist_GUI.class.getResource("/img/delete.png")));
		button.setBounds(1278, 690, 58, 54);
		tab1.add(button);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setIcon(new ImageIcon(MedicalRecordsStaff_GUI.class.getResource("/img/refresh.png")));
		btnNewButton_5.setBounds(1278, 610, 58, 54);
		tab1.add(btnNewButton_5);

		JPanel tab2 = new JPanel();
		tab2.setBackground(new Color(100, 149, 237));
		tab2.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab2.setLayout(null);
		tabbedPane.addTab("Handle change request", tab2);

		Object[][] diaryEntry;
		diaryEntry = look_up.fillUser();
		String[] diaryColumns = { "ID", "Name", "Surname", "Email", "Telephone", "Username", "UserType" };
		DefaultTableModel diarytableModel = new DefaultTableModel(diaryEntry, diaryColumns);
		JTable diaryTable = new JTable(diarytableModel);
		diaryTable.setBounds(57, 310, 812, 325);
		diaryTable.getTableHeader().setBackground(Color.pink);
		diaryTable.getTableHeader().setForeground(Color.blue);
		tf = new Font("Personnel", Font.BOLD, 12);
		diaryTable.getTableHeader().setFont(tf);
		JScrollPane scrollpane = new JScrollPane(diaryTable);
		scrollpane.setBounds(58, 341, 1164, 392);
		tab2.add(scrollpane);

		JLabel lblPatientRecords = new JLabel("Request for changes ");
		lblPatientRecords.setForeground(new Color(0, 0, 51));
		lblPatientRecords.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPatientRecords.setBounds(542, 251, 309, 46);
		tab2.add(lblPatientRecords);

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
		tab3.setBackground(new Color(100, 149, 237));
		tab3.setBorder(new EmptyBorder(5, 5, 5, 5));
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
