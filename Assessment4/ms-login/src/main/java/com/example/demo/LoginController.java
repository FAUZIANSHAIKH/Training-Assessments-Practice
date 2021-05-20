package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/rest/login")
public class LoginController 
{
	@Autowired
	private RestTemplate restTemplate;
	

	@RequestMapping(value="/callservice",method=RequestMethod.POST)

	public String invokeMethod(@RequestParam("t1") String name,@RequestParam("t2") String password)
	{
		UserDAO user=new UserDAO();
		user.setName(name);
		user.setPassword(password);
		
		String url="http://MY-AUTH-SERVICE:8093/fetch";
		
		String status=restTemplate.postForObject(url,user, String.class);
		System.out.println(status);
		if(status.equals("true"))
		{
			return "welcome";
		}
		else
		{
			return "login";
		}
	}
	
}
