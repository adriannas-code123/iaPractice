package aiPractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class User implements Serializable {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private boolean restricted;
	private transient ArrayList<Rental> userRentals;
	public static HashMap<String,User> users = new HashMap<>();
	
	//constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.userRentals = new ArrayList<>();
		users.put(username, this);
	}
	
	public  void activateUser() {
		restricted = false;
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
		this.setLastName(lastName);
		this.setEmail(email);
		this.userRentals = new ArrayList<>();
		this.restricted = false;
		users.put(username, this);
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

	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getNumberOfOngoingRentals() {
		int counter = 0;
		for( Rental rental : userRentals) {
			if(rental.getIsReturned() == false)
				counter++;
		}
		return counter;
	}
	
	public static void save() throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File usersFile = new File("users.json");
		FileWriter fileWriterUsers= new FileWriter(usersFile);
		fileWriterUsers.write(gson.toJson(users));	
		fileWriterUsers.flush();
		fileWriterUsers.close();
	}
	
}
