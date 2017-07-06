package socialapp;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import javax.validation.constraints.NotNull;

/**
 * stores user details
 */
public class User {
	private Long userID;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	
	public User(){
	}
	
	public User(String username, String password, String firstName, String lastName){
		this(null, username, password, firstName, lastName);
	}
	
	public User(Long userID, String username, String password, String firstName, String lastName){
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
