package socialapp.data;

import socialapp.User;

public interface UserRepository {
	/**
	 * saves a user and returns the saved user
	 */
	User save(User unsaved);
	User findByUsername(String username);
}
