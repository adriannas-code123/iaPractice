package aiPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ItemBrowser2 {
	
	//TODO: make sure that we can't add more droppers to the basket than we have by creating a method in Laboratory and using it in the actionPerformed method
	
	// duplicate the functionality of dropper button to all the other buttons

	private JFrame frame;
	private User loggedUser;
	private ArrayList<Rental> rentalsInBasket = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laboratory.loadInventory();
					ItemBrowser2 window = new ItemBrowser2(user);
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
	public ItemBrowser2(User user) {
		loggedUser = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ItemImage itemImage = new ItemImage();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 889, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultListModel listModel = new DefaultListModel();
		JList basketList = new JList(listModel);
		basketList.setBounds(719, 6, 164, 265);
		frame.getContentPane().add(basketList);
		
		JLabel lblNewLabel_0 = new JLabel("");
		lblNewLabel_0.setBounds(28, 0, 61, 77);
		lblNewLabel_0.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_0);
		lblNewLabel_0.setIcon(new ImageIcon(itemImage.getImage(1, 1)));
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(110, 0, 61, 77);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(itemImage.getImage(1, 2)));
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(199, 0, 61, 77);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(itemImage.getImage(1, 3)));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(297, 0, 93, 77);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(itemImage.getImage(1, 4)));
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(390, 0, 83, 77);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(itemImage.getImage(1, 4)));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(473, 0, 61, 77);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(itemImage.getImage(1, 5)));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(555, 0, 61, 77);
		frame.getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon(itemImage.getImage(1, 6)));
		
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(638, 0, 61, 77);
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon(itemImage.getImage(1, 7)));

		
		JButton btnNewButton_6 = new JButton("trough");
		btnNewButton_6.setBounds(539, 83, 76, 29);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					
					boolean flag = true;
					
					// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
					for(int i = 0; i < rentalsInBasket.size(); i ++) {
						
						if(rentalsInBasket.get(i).getItemName() == "trough") {
							rentalsInBasket.get(i).addOne();
							flag = false;
							break;
						}
						
					}
					if(flag) {
						rentalsInBasket.add(new Rental(loggedUser, "trough", 1));
					}
					System.out.println(rentalsInBasket);
				
			
			}
		});
		
		JButton btnNewButton = new JButton("dropper");
		btnNewButton.setBounds(0, 83, 89, 29);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "Dropper") {
						if(Laboratory.getStock().get("Dropper") > rentalsInBasket.get(i).getItemQuantity()) {
							rentalsInBasket.get(i).addOne();
							basketList.repaint();
						}else {
							JOptionPane.showMessageDialog(frame,
								    "No more selected item available",
								    "Inane warning",
								    JOptionPane.WARNING_MESSAGE);
						}
						flag = false;
						break;
					}
					
				}
				// Adding first time to the list
				if(flag) {
					if(Laboratory.getStock().get("Dropper") >= 1) {
						Rental rental = new Rental(loggedUser, "Dropper", 1);
						rentalsInBasket.add(rental);
						listModel.addElement(rental);
					}else {
						JOptionPane.showMessageDialog(frame,
							    "Item is unavailable",
							    "Inane warning",
							    JOptionPane.WARNING_MESSAGE);
					}
				}
				System.out.println(rentalsInBasket);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDropper = new JButton("dropper2");
		btnDropper.setBounds(94, 83, 93, 29);
		btnDropper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
					boolean flag = true;
					
					// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
					for(int i = 0; i < rentalsInBasket.size(); i ++) {
						
						if(rentalsInBasket.get(i).getItemName() == "Dropper2") {
							rentalsInBasket.get(i).addOne();
							flag = false;
							break;
						}
						
					}
					if(flag) {
						rentalsInBasket.add(new Rental(loggedUser, "Dropper2", 1));
					}
					System.out.println(rentalsInBasket);
				}
			
		});
		btnDropper.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnDropper);
		
		JButton btnNewButton_2 = new JButton("d.liquid");
		btnNewButton_2.setBounds(186, 83, 99, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					boolean flag = true;
					
					// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
					for(int i = 0; i < rentalsInBasket.size(); i ++) {
						
						if(rentalsInBasket.get(i).getItemName() == "d.liquid") {
							rentalsInBasket.get(i).addOne();
							flag = false;
							break;
						}
						
					}
					if(flag) {
						rentalsInBasket.add(new Rental(loggedUser, "D.liquid", 1));
					}
					System.out.println(rentalsInBasket);
				
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("gas jar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "Gas.jar") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "Gas.jar", 1));
				}
				System.out.println(rentalsInBasket);
			
		
		}
			
		});
		btnNewButton_3.setBounds(288, 83, 93, 29);
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("gas jar2");
		btnNewButton_4.setBounds(380, 83, 83, 29);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "gas.jar2") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "gas.jar2", 1));
				}
				System.out.println(rentalsInBasket);
			
		
		
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("breaker");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "beaker") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "beaker", 1));
				}
				System.out.println(rentalsInBasket);
			
		
		
			}
		});
		btnNewButton_5.setBounds(461, 83, 83, 29);
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("flask");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "flask") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "flask", 1));
				}
				System.out.println(rentalsInBasket);
			
		
		
			}
		});
		btnNewButton_7.setBounds(627, 83, 80, 29);
		btnNewButton_7.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(28, 117, 61, 75);
		frame.getContentPane().add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(itemImage.getImage(1, 8)));

		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(110, 117, 61, 75);
		frame.getContentPane().add(lblNewLabel_9);
		lblNewLabel_9.setIcon(new ImageIcon(itemImage.getImage(2, 1)));

		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(199, 117, 61, 75);
		frame.getContentPane().add(lblNewLabel_10);
		lblNewLabel_10.setIcon(new ImageIcon(itemImage.getImage(2, 2)));

		
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(300, 117, 93, 75);
		frame.getContentPane().add(lblNewLabel_11);
		lblNewLabel_11.setIcon(new ImageIcon(itemImage.getImage(2, 3)));

		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(390, 117, 83, 75);
		frame.getContentPane().add(lblNewLabel_12);
		lblNewLabel_12.setIcon(new ImageIcon(itemImage.getImage(2, 4)));

		
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBounds(473, 117, 61, 75);
		frame.getContentPane().add(lblNewLabel_13);
		lblNewLabel_13.setIcon(new ImageIcon(itemImage.getImage(2, 5)));

		
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBounds(555, 117, 61, 75);
		frame.getContentPane().add(lblNewLabel_14);
		lblNewLabel_14.setIcon(new ImageIcon(itemImage.getImage(2, 6)));

		
		JButton btnNewButton_9 = new JButton("conical f.");
		btnNewButton_9.setBounds(186, 197, 99, 29);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "conical.f") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "conical.f", 1));
				}
				System.out.println(rentalsInBasket);
			
			}
		});
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(647, 117, 61, 75);
		frame.getContentPane().add(lblNewLabel_15);
		lblNewLabel_15.setIcon(new ImageIcon(itemImage.getImage(2, 7)));
		

		JButton btnNewButton_1 = new JButton("flat flask");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			boolean flag = true;
			
			// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
			for(int i = 0; i < rentalsInBasket.size(); i ++) {
				
				if(rentalsInBasket.get(i).getItemName() == "flat flask") {
					rentalsInBasket.get(i).addOne();
					flag = false;
					break;
				}
				
			}
			if(flag) {
				rentalsInBasket.add(new Rental(loggedUser, "flat flask", 1));
			}
			System.out.println(rentalsInBasket);
		
	
		}	
		});
		btnNewButton_1.setBounds(0, 197, 89, 29);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_8 = new JButton("flask2");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			

			boolean flag = true;
			
			// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
			for(int i = 0; i < rentalsInBasket.size(); i ++) {
				
				if(rentalsInBasket.get(i).getItemName() == "flask2") {
					rentalsInBasket.get(i).addOne();
					flag = false;
					break;
				}
				
			}
			if(flag) {
				rentalsInBasket.add(new Rental(loggedUser, "flask2", 1));
			}
			System.out.println(rentalsInBasket);
			}
		});
		btnNewButton_8.setBounds(94, 197, 75, 29);
		btnNewButton_8.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_8);
		btnNewButton_9.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("c.f.2");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "c.f.2") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "c.f.2", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_10.setBounds(288, 197, 93, 29);
		btnNewButton_10.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("y tube");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "y.tube") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "y.tube", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_11.setBounds(380, 197, 83, 29);
		btnNewButton_11.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("test.tube");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "test.tube") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "test.tube", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_12.setBounds(461, 197, 76, 29);
		btnNewButton_12.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("t.t.2");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "t.t.2") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "t.t.2", 1));
				}
				System.out.println(rentalsInBasket);
			
			}
		});
		btnNewButton_13.setBounds(539, 197, 75, 29);
		btnNewButton_13.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("u tube");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "u.tube") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "u.tube", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_14.setBounds(638, 197, 80, 29);
		btnNewButton_14.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_14);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setBounds(28, 231, 61, 84);
		frame.getContentPane().add(lblNewLabel_16);
		lblNewLabel_16.setIcon(new ImageIcon(itemImage.getImage(2, 8)));

		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setBounds(110, 231, 61, 84);
		frame.getContentPane().add(lblNewLabel_17);
		lblNewLabel_17.setIcon(new ImageIcon(itemImage.getImage(3, 1)));

		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBounds(199, 231, 61, 84);
		frame.getContentPane().add(lblNewLabel_18);
		lblNewLabel_18.setIcon(new ImageIcon(itemImage.getImage(3, 2)));

		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setBounds(300, 231, 93, 84);
		frame.getContentPane().add(lblNewLabel_19);
		lblNewLabel_19.setIcon(new ImageIcon(itemImage.getImage(3, 3)));

		
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setBounds(390, 231, 83, 84);
		frame.getContentPane().add(lblNewLabel_20);
		lblNewLabel_20.setIcon(new ImageIcon(itemImage.getImage(3, 4)));

		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBounds(473, 231, 61, 84);
		frame.getContentPane().add(lblNewLabel_21);
		lblNewLabel_21.setIcon(new ImageIcon(itemImage.getImage(3, 5)));

		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setBounds(555, 231, 61, 84);
		frame.getContentPane().add(lblNewLabel_22);
		lblNewLabel_22.setIcon(new ImageIcon(itemImage.getImage(3, 6)));

		
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setBounds(647, 231, 61, 84);
		frame.getContentPane().add(lblNewLabel_23);
		lblNewLabel_23.setIcon(new ImageIcon(itemImage.getImage(3, 7)));

		
		
		JButton btnNewButton_15 = new JButton("u tube 2");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "u.tube.2") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "u.tube.2", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_15.setBounds(0, 320, 89, 29);
		btnNewButton_15.setToolTipText("");
		btnNewButton_15.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("pear.flask");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "pear.flask") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "pear.flask", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_16.setBounds(94, 320, 93, 29);
		btnNewButton_16.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("pear.flask2");
		btnNewButton_17.setBounds(186, 320, 99, 29);
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "pear.flask.2") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "pear.flask.2", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_17.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("suck.flask");
		btnNewButton_18.setBounds(288, 320, 93, 29);
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			boolean flag = true;
			
			// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
			for(int i = 0; i < rentalsInBasket.size(); i ++) {
				
				if(rentalsInBasket.get(i).getItemName() == "suck.flask") {
					rentalsInBasket.get(i).addOne();
					flag = false;
					break;
				}
				
			}
			if(flag) {
				rentalsInBasket.add(new Rental(loggedUser, "suck.flask", 1));
			}
			System.out.println(rentalsInBasket);
			}
		
		});
		btnNewButton_18.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("canula");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "canula") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "canula", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_19.setBounds(380, 320, 83, 29);
		btnNewButton_19.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("liebig c");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "liebig.c") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "liebig.c", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_20.setBounds(461, 320, 83, 29);
		btnNewButton_20.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("m.cylinder");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean flag = true;
				
				// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
				for(int i = 0; i < rentalsInBasket.size(); i ++) {
					
					if(rentalsInBasket.get(i).getItemName() == "m.cylinder") {
						rentalsInBasket.get(i).addOne();
						flag = false;
						break;
					}
					
				}
				if(flag) {
					rentalsInBasket.add(new Rental(loggedUser, "m.cylinder", 1));
				}
				System.out.println(rentalsInBasket);
			
				
			}
		});
		btnNewButton_21.setBounds(539, 320, 94, 29);
		btnNewButton_21.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("burette");
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			

			boolean flag = true;
			
			// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
			for(int i = 0; i < rentalsInBasket.size(); i ++) {
				
				if(rentalsInBasket.get(i).getItemName() == "burette") {
					rentalsInBasket.get(i).addOne();
					flag = false;
					break;
				}
				
			}
			if(flag) {
				rentalsInBasket.add(new Rental(loggedUser, "burette", 1));
			}
			System.out.println(rentalsInBasket);
			}
		});
		btnNewButton_22.setBounds(638, 320, 80, 29);
		btnNewButton_22.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton_22);
		JButton deleteRowButton = new JButton("Delete Row");
		deleteRowButton.setBounds(746, 283, 117, 29);
		frame.getContentPane().add(deleteRowButton);
		
		JButton proceedButton = new JButton("Proceed");
		proceedButton.setBounds(746, 319, 117, 29);
		frame.getContentPane().add(proceedButton);
	}
}
