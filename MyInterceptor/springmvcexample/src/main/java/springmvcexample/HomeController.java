package springmvcexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("going to home view....");
		
		return "form";
	}
	

	//handling for request
		@RequestMapping("/welcome") 
		public String pathVariableMethod(@RequestParam("user") String name, Model m)
		{
			System.out.println(name);
			m.addAttribute("m",name);
			return "welcome";
		}
		
		
}
