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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class ClinicalStaff_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;
	private JPanel tab4;
	private JTextField textField;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws RemoteException 
	 */
	public ClinicalStaff_GUI(User user, RMIInterface look_up) throws RemoteException, SQLException {
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
		label.setIcon(new ImageIcon(ClinicalStaff_GUI.class.getResource("/img/diagnose.png")));
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
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Accidental", "Dellberated"}));
		comboBox.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		comboBox.setBounds(287, 374, 183, 42);
		tab1.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"DANGEROUS", "NOT DANGEROUS"}));
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
		String[] possibleTreatmentsCols = { "Condition", "Medicine", "Quantity" };
		DefaultTableModel treatmentModel = new DefaultTableModel(possibleTreatments,
				possibleTreatmentsCols);
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
		DefaultTableModel currentTreatmentsModel = new DefaultTableModel(currentTreatments,
				possibleTreatmentsCols);
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
		
		
		/**********************************************************************/
		tab3 = new JPanel();
		tab3.setBackground(new Color(100, 149, 237));
		tab3.setBorder(new EmptyBorder(5, 5, 5, 5));
		tab3.setLayout(null);
		tabbedPane.addTab("View records", tab3);
		
		
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