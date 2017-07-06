package socialapp.data;

import org.springframework.stereotype.Repository;

import socialapp.User;

@Repository
public class SimpleUserRepository implements UserRepository {

	@Override
	public User save(User unsaved) {
		return new User(24L, unsaved.getUsername(), unsaved.getPassword(),
				unsaved.getFirstName(), unsaved.getLastName());
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
