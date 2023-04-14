package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("going to home view....");
		
		String str = null;
		System.out.println(str.length());
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query)
	{
		String url = "https://www.google.com/search?q=" + query;
		
		
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	//using @PathVariable
	@RequestMapping("/user/{userId}/{userName}") //PathVariable will bind with URI template variable
	public String pathVariableMethod(@PathVariable("userId") int userId,@PathVariable("userName") String userName)
	{
		System.out.println(userId);
		System.out.println(userName);
//		Integer.parseInt(userName); it will show NumberFormatException and this handler will work
		return "home";
	}
	
	
	//   handling exception in our spring mvc // if want to give many exception then use { exception.class}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) // we will send status code
	@ExceptionHandler(value= NullPointerException.class)
	public String exceptionHanderNull(Model m)
	{
		m.addAttribute("msg" , "Null pointer exception has occur");
		return "null_page";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value= NumberFormatException.class)
	public String exceptionHanderNumberFormat(Model m)
	{
		m.addAttribute("msg" , "Number Format exception has occur");
		return "null_page";
	}
	
	//generic exception
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value= Exception.class)
	public String exceptionHanderGeneric(Model m)
	{
		m.addAttribute("msg" , "Exception has occur");
		return "null_page";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
