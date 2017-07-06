package socialapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import socialapp.Post;
import socialapp.data.PostRepository;

/**
 * controller adds posts to model
 *
 */
@Controller
@RequestMapping("/posts")
public class PostController {
	private PostRepository postRepository;
	//requires a compile time constant String expression
	private static final String MAX_LONG_AS_STRING = "" + Long.MAX_VALUE;
	
	@Autowired
	PostController(PostRepository postRepository){
		this.postRepository = postRepository;
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public String posts(Model model){
		//adds postList attribute to model
		model.addAttribute("postList", postRepository.findPosts(Long.MAX_VALUE, 20));
		//returns view name posts
		return "posts";
	}*/
	
	//accepts max and count as query parameters
	@RequestMapping(method=RequestMethod.GET)
	public List<Post> posts(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max, 
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return postRepository.findPosts(max, count);
	}
	
	//accepts postID as a path parameter
	@RequestMapping(value = "/{postID}", method = RequestMethod.GET)
	public String post(
			@PathVariable("postID") long postID,
			Model model){
		model.addAttribute("post", postRepository.findOne(postID));
		return "post";
	}

}
