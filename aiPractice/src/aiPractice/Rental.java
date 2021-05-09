package aiPractice;

import java.time.LocalDateTime;

public class Rental {
	
	private User user;
	private LocalDateTime rentDateTime;
	private String itemName;
	private int itemQuantity; 
	private boolean isReturned;
	
	
	 
	public Rental( User user, LocalDateTime rentDateTime, String itemName, int itemQuantity) {
		
		this.user = user;
		this.rentDateTime = rentDateTime;
		this.itemName = itemName;
		this.isReturned = false;
		this.itemQuantity = itemQuantity;
		
	}
	
	public Rental( User user, String itemName, int itemQuantity) {
		this(user, LocalDateTime.now(), itemName, itemQuantity);
	}
	
	public void setIsReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	
	public String getItemName() {
		
		return itemName;
		
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public LocalDateTime getRentDateTime() {
		return rentDateTime;
	}
	
	public boolean getIsReturned() {
		
		return isReturned;
	}
	
	public User getUser() {
		return user;
	}
	
	public void addOne() {
		this.itemQuantity += 1;
	}

	public String toString() {
		return this.itemName + " : " + this.itemQuantity;
	}

	public void replaceQuantity(int newQuantity) {
		this.itemQuantity = newQuantity;
		
	}
	
	public boolean isOverDue() {
		return LocalDateTime.now().isAfter(rentDateTime.plusDays(7));
	}
}
