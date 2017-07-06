package socialapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//allows component scan to find this controller
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {
	//returns "home" view for requests to /
	@RequestMapping(method = RequestMethod.GET)
	public String home(){
		return "home";
	}

}
