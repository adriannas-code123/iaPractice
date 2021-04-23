package aiPractice;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class LoginWindow {

	private JFrame frame;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton loginButton;
	private JLabel infoLabel;
	private User users[] = {new User("Ada", "123"), new User("Jan", "abc")}; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Checkout log");
		lblNewLabel.setBounds(147, 26, 145, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel usernameLabel = new JLabel("username");
		usernameLabel.setBounds(48, 79, 61, 16);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setBounds(48, 117, 61, 16);
		frame.getContentPane().add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(128, 74, 150, 26);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(128, 112, 150, 26);
		frame.getContentPane().add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(161, 177, 117, 29);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < users.length; i++) {
					
					if(usernameField.getText().equals(users[i].getUsername()) && passwordField.getText().equals(users[i].getPassword())) {
						User loggedUser = users[i];
						// now check if his rentals are overdue if so restrict this user!
						LocalDateTime loginTime = LocalDateTime.now();
						for(int j = 0; j < loggedUser.getUserRentals().size(); j++) {
							LocalDateTime rentalDate= loggedUser.getUserRentals().get(j).getRentDateTime();
							if((rentalDate.plusDays(14).isBefore(loginTime)) && loggedUser.getUserRentals().get(j).getIsReturned() == false) {
								loggedUser.restrictUser();
							}
							
						}
						frame.dispose();
						new OptionWindow(loggedUser);
						;
						break;
					}
					else if(i == users.length - 1) {
						infoLabel.setText("Invalid credentials");
						
					}
					
				
				}
					
			}
		});
		
		frame.getContentPane().add(loginButton);
		
		infoLabel = new JLabel("");
		infoLabel.setForeground(Color.RED);
		infoLabel.setBounds(128, 218, 198, 16);
		frame.getContentPane().add(infoLabel);
		
	}
}
