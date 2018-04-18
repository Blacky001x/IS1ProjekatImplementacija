package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.GlobalData;
import model.User;
import repository.UserRepositoryMock;

public class RegisterForm extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIme;
	private JTextField tfPrezime;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setTitle("Registracija");
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
		lblUsername.setBounds(104, 125, 63, 22);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(104, 158, 63, 22);
		panel.add(lblPassword);

		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(104, 72, 63, 14);
		panel.add(lblIme);

		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(104, 100, 63, 14);
		panel.add(lblPrezime);

		tfIme = new JTextField();
		tfIme.setBounds(212, 69, 126, 20);
		panel.add(tfIme);
		tfIme.setColumns(10);

		tfPrezime = new JTextField();
		tfPrezime.setBounds(212, 97, 126, 20);
		panel.add(tfPrezime);
		tfPrezime.setColumns(10);

		textField = new JTextField();
		textField.setBounds(212, 126, 126, 20);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(212, 157, 126, 20);
		panel.add(passwordField);

		JButton btnRegistracija = new JButton("Registracija");
		
		// when register button is checked, we perfom some validation of input (not empty), 'fail-fast' methodology applied
		// and we try to register new user
		btnRegistracija.addActionListener(e -> {
			if (tfIme.getText() == null || tfIme.getText().length() == 0) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Niste uneli ime!", "Neuspesno", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String firstName = tfIme.getText();
			
			if (tfPrezime.getText() == null || tfPrezime.getText().length() == 0) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Niste uneli prezime!", "Neuspesno", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String lastName = tfPrezime.getText();
			
			if (textField.getText() == null || textField.getText().length() == 0) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Niste uneli korisnicko ime!", "Neuspesno", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String username = textField.getText();
			
			if (passwordField.getPassword() == null || passwordField.getPassword().length <= 4) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Lozinka nije dovoljno dugacka!", "Neuspesno", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String password = new String(passwordField.getPassword());
			
			UserRepositoryMock repo = new UserRepositoryMock();
			User user = repo.registerUser(firstName, lastName, username, password);
			if (user == null) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Greska prilikom registracije.\nKorisnicko ime koje ste uneli je zauzeto!"
						+ "!", "Neuspesno", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				GlobalData.activeUser = user;
			}
			new AllMoviesForm();
			this.dispose();
			
		});
		btnRegistracija.setBounds(151, 209, 115, 23);
		panel.add(btnRegistracija);
	}
}
