package aiPractice;

import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private boolean restricted;
	private ArrayList<Rental> userRentals;
	
	//constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.userRentals = new ArrayList<>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public User( String username, String password, String firstName, String lastName, String email) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRentals = new ArrayList<>();
		this.restricted = false;
	}
	
	public boolean isRestricted() {
		return restricted;
	}
	
	public void restrictUser() {
		
		restricted = true;
	}
	
	public ArrayList<Rental> getUserRentals(){
		return userRentals;
	}
}
