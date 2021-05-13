package aiPractice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;

public class ItemBrowser {
	
	//TODO: make sure that we can't add more droppers to the basket than we have by creating a method in Laboratory and using it in the actionPerformed method
	
	// duplicate the functionality of dropper button to all the other buttons

	private JFrame frame;
	private User loggedUser;
	private ArrayList<Rental> rentalsInBasket = new ArrayList<>();

	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemBrowser window = new ItemBrowser(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ItemBrowser(User user) {
		loggedUser = user;
		initialize();
	}

	private void initialize() {
			
		frame = new JFrame();
		frame.setBounds(100, 100, 889, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ItemImage itemImage = new ItemImage();
		addLabels(frame, itemImage);
		
		DefaultListModel listModel = new DefaultListModel();
		JList basketList = new JList(listModel);
		basketList.setBounds(719, 6, 164, 265);
		frame.getContentPane().add(basketList);
		
		SpinnerModel model = new SpinnerNumberModel(0,0,1000,1);
		JSpinner spinner = new JSpinner(model);
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		spinner.setBounds(380, 361, 61, 60);
		frame.getContentPane().add(spinner);
			
		
		JButton button = new JButton("dropper");
		button.setBounds(0, 83, 89, 29);
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("Dropper", basketList, listModel, (int) spinner.getValue());
				System.out.println(Laboratory.getStock().get("Dropper"));
			}
		});
		frame.getContentPane().add(button);
		
		
		JButton btnDropper = new JButton("dropper2");
		btnDropper.setBounds(94, 83, 93, 29);
		btnDropper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				updateBasket("Dropper 2", basketList, listModel, (int) spinner.getValue());
				}
			
		});
		btnDropper.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(btnDropper);
		
		JButton button_2 = new JButton("d.liquid");
		button_2.setBounds(186, 83, 99, 29);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateBasket("d.liquid", basketList, listModel, (int) spinner.getValue());
				
			}
		});
		button_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("gas.jar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateBasket("gas.jar", basketList, listModel, (int) spinner.getValue());
			
		}
			
		});
		button_3.setBounds(288, 83, 93, 29);
		button_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("gas.jar2");
		button_4.setBounds(380, 83, 83, 29);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("gas.jar2", basketList, listModel, (int) spinner.getValue());
					}

		});
		
		button_4.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("breaker");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateBasket("beaker", basketList, listModel, (int) spinner.getValue());
			}
		});
		button_5.setBounds(461, 83, 83, 29);
		button_5.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("trough");
		button_6.setBounds(539, 83, 76, 29);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateBasket("trough", basketList, listModel, (int) spinner.getValue());
			}
		});
		
		button_6.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("flask");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			updateBasket("flask", basketList, listModel, (int) spinner.getValue());
			}
		});
		button_7.setBounds(627, 83, 80, 29);
		button_7.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_7);
		
		

		
		JButton button_9 = new JButton("conical.f.");
		button_9.setBounds(186, 197, 99, 29);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateBasket("conical.f.", basketList, listModel, (int) spinner.getValue());
				}
			});
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(647, 117, 61, 75);
		frame.getContentPane().add(lblNewLabel_15);
		lblNewLabel_15.setIcon(new ImageIcon(itemImage.getImage(2, 7)));
		

		JButton button_1 = new JButton("flat flask");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("flat flask", basketList, listModel, (int) spinner.getValue());
			}
		});
		
		button_1.setBounds(6, 197, 89, 29);
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_1);
		
		JButton button_8 = new JButton("flask2");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("flask2", basketList, listModel, (int) spinner.getValue());
			}
		});
		button_8.setBounds(94, 197, 93, 29);
		button_8.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_8);
		button_9.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("c.f.2");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateBasket("conical flask 2", basketList, listModel, (int) spinner.getValue());
				
			}
		});
		button_10.setBounds(288, 197, 93, 29);
		button_10.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("y tube");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateBasket("y tube", basketList, listModel, (int) spinner.getValue());
			
				
			}
		});
		button_11.setBounds(380, 197, 83, 29);
		button_11.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("test.tube");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateBasket("test.tube", basketList, listModel, (int) spinner.getValue());
			
				
			}
		});
		button_12.setBounds(461, 197, 76, 29);
		button_12.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("t.t.2");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateBasket("test tube 2", basketList, listModel, (int) spinner.getValue());
			
			}
		});
		button_13.setBounds(539, 197, 75, 29);
		button_13.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_13);
		
		JButton button_14 = new JButton("u tube");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("u tube", basketList, listModel, (int) spinner.getValue());
				
			}
		});
		button_14.setBounds(638, 197, 80, 29);
		button_14.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_14);
				
		JButton button_15 = new JButton("u tube 2");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateBasket("u tube 2", basketList, listModel, (int) spinner.getValue());
			
				
			}
		});
		button_15.setBounds(0, 320, 89, 29);
		button_15.setToolTipText("");
		button_15.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_15);
		
		JButton button_16 = new JButton("pear.flask");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("pear.flask", basketList, listModel, (int) spinner.getValue());
				
			}
		});
		button_16.setBounds(94, 320, 93, 29);
		button_16.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_16);
		
		JButton button_17 = new JButton("pear.flask2");
		button_17.setBounds(186, 320, 99, 29);
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateBasket("pear.flask 2", basketList, listModel, (int) spinner.getValue());
			
				
			}
		});
		button_17.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_17);
		
		JButton button_18 = new JButton("suck.flask");
		button_18.setForeground(Color.BLACK);
		
		button_18.setBounds(288, 320, 93, 29);
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				updateBasket("suction flask", basketList, listModel, (int) spinner.getValue());
			}
		
		});
		button_18.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_18);
		
		JButton button_19 = new JButton("canula");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("canula", basketList, listModel, (int) spinner.getValue());
			
				
			}
		});
		button_19.setBounds(380, 320, 83, 29);
		button_19.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_19);
		
		JButton button_20 = new JButton("liebig c");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("liebig c", basketList, listModel, (int) spinner.getValue());
			
				
			}
		});
		button_20.setBounds(461, 320, 83, 29);
		button_20.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_20);
		
		JButton button_21 = new JButton("m.cylinder");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			updateBasket("m.cylinder", basketList, listModel, (int) spinner.getValue());
			
				
			}
		});
		button_21.setBounds(638, 320, 76, 29);
		button_21.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_21);
		
		JButton button_22 = new JButton("burette");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBasket("burette", basketList, listModel, (int) spinner.getValue());
			
			}
		});
		button_22.setBounds(539, 320, 94, 29);
		button_22.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		frame.getContentPane().add(button_22);
		frame.getContentPane().add(button_22);
		
		
		JButton proceedButton = new JButton("Proceed");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				for(int i = 0; i< rentalsInBasket.size(); i ++) {
					
					if(!Laboratory.rentItems(rentalsInBasket.get(i)))
							flag = false;
				}
				rentalsInBasket.removeAll(rentalsInBasket);
				listModel.removeAllElements();
				basketList.repaint();
				if(flag) {
				try {
					Laboratory.save();
					User.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				new OptionWindow(loggedUser);
				} else {
					JOptionPane.showMessageDialog(frame,
						    "You are restricted",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		proceedButton.setBounds(746, 319, 117, 29);
		frame.getContentPane().add(proceedButton);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new OptionWindow(loggedUser);
			}
		});
		btnNewButton.setBounds(17, 380, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("select item quantity");
		lblNewLabel.setBounds(236, 385, 125, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}

	
	public void updateBasket(String item, JList basketList, DefaultListModel listModel, int spinnerQuantity) {
		boolean flag = true;
		
		// if itemquantityinBasket > stock Quantity dont append BasketList & display dialog window no more selected item available" 
		for(int i = 0; i < rentalsInBasket.size(); i++) {
		
			if(rentalsInBasket.get(i).getItemName().equals(item)) {
				if(spinnerQuantity == 0 ){
					rentalsInBasket.remove(i);
					listModel.remove(i);
					break;
				}
				if(Laboratory.getStock().get(item) >= spinnerQuantity) {
					rentalsInBasket.get(i).replaceQuantity(spinnerQuantity);
					
					basketList.repaint();
				}else {
					JOptionPane.showMessageDialog(frame,
						    "Given amount of the selected item is unavailable",
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				flag = false;
				break;
			}
			
		}
		// Adding first time to the basket list
		if(flag && spinnerQuantity > 0) {
			if(Laboratory.getStock().get(item) >= spinnerQuantity) {
				Rental rental = new Rental(loggedUser, item, spinnerQuantity);
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
	
	public void addLabels(JFrame frame, ItemImage itemImage) {
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
	}
}
