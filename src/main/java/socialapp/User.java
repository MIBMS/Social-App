package socialapp;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

/**
 * stores user details
 */
public class User {
	private Long userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	public User(){
		this(null, null, null, null);
	}
	
	public User(String username, String password, String firstName, String lastName){
		this(null, username, password, firstName, lastName);
	}
	
	public User(Long userId, String username, String password, String firstName, String lastName){
		this.userID = 24L;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	@Override
	public boolean equals(Object that){
		return EqualsBuilder.reflectionEquals(this, that, "userID");
	}
	
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this, "userID");
	}
}
