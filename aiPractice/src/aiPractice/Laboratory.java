package aiPractice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Laboratory {
	
	private static HashMap<String, Integer> stock = new HashMap<>();
	private static ArrayList<Rental> rentals = new ArrayList<>();
	
	public static void loadInventory() {
		stock.put("Dropper", 20);
		stock.put("Dropper 2", 20);
		stock.put("d.liquid", 20);
		stock.put("gas.jar", 20);
		stock.put("gas.jar2", 20);
		stock.put("beaker", 20);
		stock.put("trough", 20);
		stock.put("flask", 20);
		stock.put("flat flask", 20);
		stock.put("flask2", 20);
		stock.put("conical.f.", 20);
		stock.put("conical flask 2", 20);
		stock.put("y tube", 20);
		stock.put("test.tube", 20);
		stock.put("test tube 2", 20);
		stock.put("u tube", 20);
		stock.put("u tube 2", 20);
		stock.put("pear.flask", 20);
		stock.put("pear.flask 2", 20);
		stock.put("suction flask", 20);
		stock.put("canula", 20);
		stock.put("liebig c", 20);
		stock.put("m.cylinder", 20);
		
//		rentItems(new User("Ada", "123"), "Dropper", 2);
	}
	
	
	
	public static HashMap<String, Integer> getStock() {
		return stock;
	}
	
	public static boolean rentItems(User user, String itemName, Integer quantity) { //make sure that quantity is <= stock in lab if it's not then return false;
		Integer currentStock = stock.get(itemName);
		if(quantity > currentStock || user.isRestricted()) {
			return false;
		}
		
		stock.replace(itemName, currentStock - quantity);
		
		Rental newRental = new Rental(user, LocalDateTime.now(), itemName, quantity);
		rentals.add(newRental);
		user.getUserRentals().add(newRental);
		
		return true;
	}
	// only for testing 
	private static boolean rentItems(User user, String itemName, Integer quantity, LocalDateTime rentDateTime) { 
		Integer currentStock = stock.get(itemName);
		if(quantity > currentStock || user.isRestricted()) {
			return false;
		}
		
		stock.replace(itemName, currentStock - quantity);
		
		Rental newRental = new Rental(user, rentDateTime, itemName, quantity);
		rentals.add(newRental);
		user.getUserRentals().add(newRental);
		
		return true;
	}
	
	public static boolean rentItems(Rental rental) {
		return rentItems(rental.getUser(), rental.getItemName(), rental.getItemQuantity());
	}

	
	// TODO method below, + read about HashMap + OOP!!, method to return rented items back to stock
	// Try uploading it on GitHub.
	public static void returnItems(Rental rental) {
		Integer currentStock = stock.get(rental.getItemName());
		stock.replace( rental.getItemName(), currentStock + rental.getItemQuantity());
		
		rental.setIsReturned(true);
		
	}
	
	public static ArrayList<Rental> getRentals(){
		return rentals;
	}

}
