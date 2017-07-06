package socialapp;

import java.util.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Stores id, time, message and location of the user when message was entered
 */
public class Post {
	private final Long id;
	private final Date time;
	private final String message;
	private Double latitude;
	private Double longitude;
	
	public Post(String message, Date time){
		this(message, time, null, null);
	}
	
	public Post(String message, Date time, Double latitude, Double longitude){
		this.id = null;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public Date getTime(){
		return this.time;
	}
	
	public String getMessage(){
		return this.message;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	
	@Override
	public boolean equals(Object that){
		return EqualsBuilder.reflectionEquals(this, that, "time", "id");
	}
	
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this, "time", "id");
	}
	
	

}
