package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//hey spring mvc this is my excpetion class for that we use @ControllerAdvice

@ControllerAdvice
public class MyExceptionHandler {
	
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
