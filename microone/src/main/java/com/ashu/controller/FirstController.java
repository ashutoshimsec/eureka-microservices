package com.ashu.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashu.modal.Employee;
import com.ashu.service.MicroserviceTwoService;

@RestController
public class FirstController {

	@Autowired
	private MicroserviceTwoService twoservice; 
	
	@Autowired
	private LoadBalancerClient lbc;

	RestTemplate rt = new RestTemplate();
	
	
	
	@GetMapping("/test")
	public String test() {
		return "welcome to first microservice";
		
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
	 	return response+" from host "+zuulUrl;
		
	}
	
	
	@GetMapping("/secondapps")
	public String secondapps() {
		
		 String zuulUrl = lbc.choose("ASHU-ZUUL-SERVICE").getUri().toString();
		System.out.println("the zuulUrl url is "+zuulUrl);
	 	String response = rt.getForObject(zuulUrl+"/two/test/", String.class );
	 	return response+" from host "+zuulUrl;
		
	}
	
	@GetMapping("/thirdapps")
	public String thirdapps() {
		
		 String zuulUrl = lbc.choose("ASHU-ZUUL-SERVICE").getUri().toString();
		System.out.println("the zuulUrl url is "+zuulUrl);
	 	String response = rt.getForObject(zuulUrl+"/three/test/", String.class );
	 	return response+" from host "+zuulUrl;
		
	}
	
	@GetMapping("/getAllEmp")
	public Collection<Employee> getAllEmp() {
	
		Collection<Employee> res = twoservice.findAll();
	  	return res;
		
	}
	
	
}
