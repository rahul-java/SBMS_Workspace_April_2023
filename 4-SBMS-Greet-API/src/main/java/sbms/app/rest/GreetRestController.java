package sbms.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sbms.app.client.WelcomeApiClient;

@RestController
public class GreetRestController {

	@Autowired
	private WelcomeApiClient welcomeApiClient;
	@Autowired
	private Environment environment;
	
	@GetMapping("/greet")
	public String greetMsg()
	{
		String portNo = environment.getProperty("server.port");
		String greetMsg="Good Morning...!!! "+"( port no ::: "+portNo+" )";
		String welcomeMsg = welcomeApiClient.invokeWelcomeApi();
		return greetMsg + welcomeMsg;
	}
}
