package socialapp.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import socialapp.Post;
import socialapp.User;
import socialapp.data.PostRepository;
import socialapp.data.UserRepository;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
		//creates expectedPosts, sets up the mock repository so we get expected posts when findPosts is called
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
	
	/**
	 * tests getting a post via path parameters
	 * @throws Exception 
	 */
	@Test
	public void testPost() throws Exception{
		Post expectedPost = new Post("Hello", new Date());
		PostRepository mockRepository = mock(PostRepository.class);
		when(mockRepository.findOne(123)).thenReturn(expectedPost);
		
		//creates a mock Mvc based on the mock repository
		//expect a post view to be returned
		//model should contain a post attribute with the expected post
		PostController controller = new PostController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/posts/123")).andExpect(view().name("post"))
			.andExpect(model().attributeExists("post")).andExpect(model().attribute("post", expectedPost));
	}
	
	@Test
	public void testRegistrationForm() throws Exception{
		UserRepository mockRepository = mock(UserRepository.class);
		RegistrationController controller = new RegistrationController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/SocialApp/register")).andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception{
		UserRepository mockRepository = mock(UserRepository.class);
		User unsaved = new User("jbauer", "24hours", "Jack", "Bauer");
		User saved = new User(1L, "jbauer", "24hours", "Jack", "Bauer");
		when(mockRepository.save(unsaved)).thenReturn(saved);
		
		RegistrationController controller = new RegistrationController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		//checks that the user is redirected to the correct address after the post request
		mockMvc.perform(post("/SocialApp/register")
				.param("firstName", "Jack")
				.param("lastName", "Bauer")
				.param("username", "jbauer")
				.param("password", "24hours")).andExpect(redirectedUrl("/SocialApp/jbauer"));
		
		//checks that the mockMvc has run the save method of the user repository at least once
		verify(mockRepository, atLeastOnce()).save(unsaved);
	}
	
}
