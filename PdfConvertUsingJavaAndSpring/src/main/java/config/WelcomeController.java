package config;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	WelcomeService welcomeService ;
	
	@RequestMapping("/welcome")
	public String welcome() throws FileNotFoundException, Exception {
		welcomeService.fifthPdf();
		return "Hello";
	}
	@RequestMapping("/first")
	public String first() throws FileNotFoundException, Exception {
		welcomeService.firstPdf();
		return "Hello";
	}
	@RequestMapping("/second")
	public String second() throws FileNotFoundException, Exception {
		welcomeService.secondPdf();
		return "Hello";
	}
	@RequestMapping("/third")
	public String third() throws FileNotFoundException, Exception {
		welcomeService.thirdPdf();
		return "Hello";
	}
	@RequestMapping("/fourth")
	public String fourth() throws FileNotFoundException, Exception {
		welcomeService.fourthPdf();
		return "Hello";
	}
	
	
}