package socialapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

import socialapp.User;
import socialapp.data.UserRepository;

/**
 * Handles registration of a user
 */
@Controller
@RequestMapping("/SocialApp")
public class RegistrationController {
	private UserRepository repository;
	
	@Autowired
	RegistrationController(UserRepository repository){
		this.repository = repository;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(){
		return "registerForm";
	}
	
	/**
	 * processes a POST request with new user information
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@Valid User user, Errors errors){
		if (errors.hasErrors()){
			return "registerForm";
		}
		
		repository.save(user);
		//asks the ViewResolver to redirect to a new URL, since DDL operations will be done
		return "redirect:/SocialApp/" + user.getUsername();
	}
	
	/**
	 * processes a request to /SocialApp/{username}
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showUserProfile(
			@PathVariable("username") String username,
			Model model
			){
		User user = repository.findByUsername(username);
		model.addAttribute("user", user);
		return "profile";
	}
}
