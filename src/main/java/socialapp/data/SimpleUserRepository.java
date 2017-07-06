package socialapp.data;

import org.springframework.stereotype.Repository;

import socialapp.User;

@Repository
public class SimpleUserRepository implements UserRepository {
	private static Long lastUserID = 0L;
	
	@Override
	public User save(User unsaved) {
		return new User(lastUserID++, unsaved.getUsername(), unsaved.getPassword(),
				unsaved.getFirstName(), unsaved.getLastName());
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
