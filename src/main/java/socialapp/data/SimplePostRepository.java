package socialapp.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import socialapp.Post;

@Repository
public class SimplePostRepository implements PostRepository{

	@Override
	public List<Post> findPosts(long max, int count) {
		return new ArrayList<Post>();
	}
	
}
