package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.log_in;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Semaphore;

public class HomePage_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Semaphore semaphore =new Semaphore(0);
	private JLabel msgAlert = new JLabel("");

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public HomePage_GUI(log_in login) throws InterruptedException {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(68, 220, 117, 33);
		contentPane.add(panel_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblUsername);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(68, 286, 117, 30);
		contentPane.add(panel_2);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblPassword);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(246, 220, 137, 30);
		contentPane.add(panel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(246, 286, 137, 33);
		contentPane.add(panel);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel.add(passwordField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(68, 11, 298, 33);
		contentPane.add(panel_4);
		
		JLabel lblWelcomeOnClinical = new JLabel("Welcome on clinical phychology");
		lblWelcomeOnClinical.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeOnClinical.setForeground(Color.RED);
		panel_4.add(lblWelcomeOnClinical);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 424, 494);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(153, 365, 120, 51);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(0, 0, 120, 51);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_6.add(btnLogin);
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login.setUsername(textField.getText());
				String password= new String(passwordField.getPassword());
				login.setPassword(password);	
				semaphore.release();
			}
		});		
		setVisible(true);
		
	}

	public void waitForInput() throws InterruptedException {
	    semaphore.acquire();		    
	}

	public void alertForWrongLogin() {
		msgAlert.setText("Wrong username/password");
		
	}
}