package socialapp.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import socialapp.Post;
import socialapp.data.PostRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import org.hamcrest.MatcherAssert;

public class ControllersTest {
	@Test
	public void testHomepage() throws Exception{
		HomeController controller = new HomeController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
	
	@Test
	public void shouldShowRecentPosts() throws Exception{
		//creates expectedPosts and tries to get them from the mock Repository
		List<Post> expectedPosts = createPostList();
		PostRepository postRepository = mock(PostRepository.class);
		when(postRepository.findPosts(Long.MAX_VALUE, 20)).thenReturn(expectedPosts);
		
		//creates a mock MVC based on the mock Repository and compares the results to the expected Posts
		PostController postController = new PostController(postRepository);
		MockMvc mockMvc = standaloneSetup(postController)
				.setSingleView(new InternalResourceView("/WEB-INF/views/posts.jsp")).build();
		mockMvc.perform(get("/posts")).andExpect(view().name("posts"))
				.andExpect(model().attributeExists("postList"))
				.andExpect(model().attribute("postList", hasItems(expectedPosts.toArray())));
		
	}
	
	@Test
	public void shouldShowPagedPosts() throws Exception{
		List<Post> expectedPosts = createPostList();
		PostRepository postRepository = mock(PostRepository.class);
		when(postRepository.findPosts(23311, 50)).thenReturn(expectedPosts);
		
		PostController postController = new PostController(postRepository);
		MockMvc mockMvc = standaloneSetup(postController)
				.setSingleView(new InternalResourceView("/WEB-INF/views/posts.jsp")).build();
		mockMvc.perform(get("/posts?max=23311&count=50")).andExpect(view().name("posts"))
				.andExpect(model().attributeExists("postList"))
				.andExpect(model().attribute("postList", hasItems(expectedPosts.toArray())));
	}
	
	private List<Post> createPostList(){
		List<Post> posts = new ArrayList<Post>();
		for(int i = 0; i < 20; i++){
			posts.add(new Post("Post " + i, new Date()));
		}
		return posts;
	}
}
