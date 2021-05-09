package aiPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ReturnWindow {
	private JFrame frame;
	private User loggedUser;

	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnWindow window = new ReturnWindow(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReturnWindow(User user) {
		loggedUser = user;
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 469, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello "+ loggedUser.getUsername());
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(131, 25, 200, 38);
		frame.getContentPane().add(lblNewLabel);
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		
		for(Rental rental : Laboratory.getRentals()) {
			if(rental.getUser().getUsername().equals(loggedUser.getUsername()) && rental.getIsReturned() == false) {
				listModel.addElement(rental);
			}
		}
		list.setBounds(20, 109, 201, 244);
		frame.getContentPane().add(list);
		
		JLabel  overdueLabel = new JLabel("");
		overdueLabel.setForeground(Color.RED);
		overdueLabel.setBounds(147, 364, 304, 67);
		frame.getContentPane().add(overdueLabel);
		for(Rental rental : Laboratory.getRentals()) {
			System.out.println(rental.isOverDue());
			if(rental.getIsReturned() == false && rental.isOverDue() && rental.getUser().getUsername().equals(loggedUser.getUsername())) {
				overdueLabel.setText("PLEASE RETURN OVERDUE RENTALS");
				frame.repaint();
			}
		}
		JButton btnNewButton = new JButton("Return selected rental");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Laboratory.returnItems((Rental)(list.getSelectedValue()));
			listModel.removeElement((Rental)(list.getSelectedValue()));
			list.repaint();
			
			boolean flag = true;
			for(int i = 0; i< loggedUser.getUserRentals().size(); i ++) {
				if(loggedUser.getUserRentals().get(i).isOverDue())
						
						flag = false;
			}
				loggedUser.activateUser();
			
			}
		});
		btnNewButton.setBounds(243, 315, 155, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new OptionWindow(loggedUser);
			}
		});
		btnNewButton_1.setBounds(20, 379, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	
}
