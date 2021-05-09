package aiPractice;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Userlist{

	private JFrame frame;
	private  User loggedUser;
	private JTable table;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(User user){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userlist window = new Userlist(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Userlist(User user) {
		loggedUser = user;
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 736, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		String[] columns = {"USERNAME", "FIRST NAME", "LAST NAME", "EMAIL", "ONGOING RENTALS", "RESTRICTED"};
		String[][] data = new String[User.users.size()][6];
		
		User.users.values();
		int  i = 0;
		for( User user : User.users.values()) {
			
			data[i][0] = user.getUsername();
			data[i][1] = user.getFirstName();
			data[i][2] = user.getLastName();
			data[i][3] = user.getEmail();
			data[i][4] = Integer.toString(user.getNumberOfOngoingRentals());
			data[i][5] = user.isRestricted() ? "YES" : "NO";
			
			i++;
		}
	
		
		JTable table = new JTable(data, columns);
		
		
		DefaultTableModel model = new DefaultTableModel();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 710, 362);
		frame.getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new OptionWindow(loggedUser);
			}
		});
		btnNewButton.setBounds(17, 380, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
}