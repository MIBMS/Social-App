package socialapp.data;

import java.util.List;
import socialapp.Post;

/**
 * Allows users to find a social app post
 */
public interface PostRepository {
	/**
	 * returns a post
	 * @param max max post ID to return
	 * @param count number of posts to return
	 * @return
	 */
	List<Post> findPosts(long max, int count);
}
