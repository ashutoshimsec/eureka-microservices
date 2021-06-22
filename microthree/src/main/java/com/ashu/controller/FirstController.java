package com.ashu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FirstController {

	
	@Autowired
	private LoadBalancerClient lbc;

	RestTemplate rt = new RestTemplate();
	
	
	
	@GetMapping("/test")
	public String test() {
		return "welcome to third microservice";
		
	}
	
	@GetMapping("/appUrl")
	public String commonFuncation() {
		
	String url = 	lbc.choose("one").getUri().toString();
	System.out.println("the url is "+url);
	return url;
		
	}
	
	@GetMapping("/firstapps")
	public String firstapps() {
		
		 String zuulUrl = lbc.choose("ASHU-ZUUL-SERVICE").getUri().toString();
		System.out.println("the zuulUrl url is "+zuulUrl);
	 	String response = rt.getForObject(zuulUrl+"/one/test/", String.class );
	 	return response;
		
	}
	
	
	@GetMapping("/secondapps")
	public String secondapps() {
		
		 String zuulUrl = lbc.choose("ASHU-ZUUL-SERVICE").getUri().toString();
		System.out.println("the zuulUrl url is "+zuulUrl);
	 	String response = rt.getForObject(zuulUrl+"/two/test/", String.class );
	 	return response;
		
	}
	
	@GetMapping("/thirdapps")
	public String thirdapps() {
		
		 String zuulUrl = lbc.choose("ASHU-ZUUL-SERVICE").getUri().toString();
		System.out.println("the zuulUrl url is "+zuulUrl);
	 	String response = rt.getForObject(zuulUrl+"/three/test/", String.class );
	 	return response;
		
	}
}
