package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.GlobalData;
import model.User;
import repository.UserRepositoryMock;

import javax.swing.JPasswordField;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfusername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(108, 73, 80, 22);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(108, 125, 80, 14);
		panel.add(lblPassword);
		
		tfusername = new JTextField();
		tfusername.setBounds(203, 74, 102, 20);
		panel.add(tfusername);
		tfusername.setColumns(10);
		
		JButton btnLogin = new JButton("Prijava");
		
		// user is trying to log in, input validation is performed, system do 'fail-fast' if something is wrong
		btnLogin.addActionListener(event -> {
			
			if (tfusername.getText() == null || tfusername.getText().length() == 0) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Niste uneli korisnicko ime!", "Neuspesno", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (passwordField.getPassword() == null || passwordField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Niste uneli password!", "Neuspesno", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String username = tfusername.getText();
			String password = new String(passwordField.getPassword());
			System.out.println(username + " : " + password);
			UserRepositoryMock repo = new UserRepositoryMock();
			User user = repo.findUser(username, password);
			
			// is user found with entered data?
			if (user == null) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Pogresno korisnicko ime ili lozinka!", "Prijava nije uspela", JOptionPane.ERROR_MESSAGE);
			} else {
				GlobalData.activeUser = user;
				new AllMoviesForm();
				this.dispose();
			}
		});
		btnLogin.setBounds(244, 202, 102, 23);
		panel.add(btnLogin);
		
		JButton btnRegister = new JButton("Registracija");
		btnRegister.addActionListener(event -> {
			RegisterForm regForm = new RegisterForm();
			regForm.setVisible(true);
			this.dispose();
			
		});
		btnRegister.setBounds(75, 202, 102, 23);
		panel.add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 122, 102, 20);
		panel.add(passwordField);
	}

}
