package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.log_in;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
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
		setBounds(100, 100, 1047, 799);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(646, 509, 184, 37);
		contentPane.add(panel_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_1.add(lblUsername);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(646, 594, 184, 37);
		contentPane.add(panel_2);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_2.add(lblPassword);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(936, 509, 184, 37);
		contentPane.add(panel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 17));
		textField.setColumns(10);
		panel_3.add(textField);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(936, 594, 184, 37);
		contentPane.add(panel);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 17));
		passwordField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(706, 703, 414, 47);
		contentPane.add(btnLogin);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(119, 136, 153));
		panel_5.setBounds(492, 277, 842, 82);
		contentPane.add(panel_5);
		
		JLabel lblWelcomeOnClinical = new JLabel("Welcome to clinical phychology");
		panel_5.add(lblWelcomeOnClinical);
		lblWelcomeOnClinical.setVisible(true);
		lblWelcomeOnClinical.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblWelcomeOnClinical.setForeground(Color.WHITE);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HomePage_GUI.class.getResource("/img/crinical.png")));
		label.setBounds(0, -39, 1910, 1033);
		contentPane.add(label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(247, 138, 498, 75);
		contentPane.add(panel_4);
		
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
