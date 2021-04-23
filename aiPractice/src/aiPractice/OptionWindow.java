package aiPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionWindow{

	private JFrame frame;
	private  User loggedUser;
	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public OptionWindow(User user) {
		loggedUser = user;
		start();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton rentButton = new JButton("RENT");
		rentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ItemBrowser2.main(null);
			}
		});
		rentButton.setBounds(154, 59, 136, 51);
		frame.getContentPane().add(rentButton);
		
		JButton returnButton = new JButton("RETURN");
		returnButton.setBounds(154, 122, 136, 51);
		frame.getContentPane().add(returnButton);
	}
}
