package com.ashu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashu.modal.Employee;

@RestController
public class FirstController {

	
	@Autowired
	private LoadBalancerClient lbc;

	RestTemplate rt = new RestTemplate();
	
	
	
	@GetMapping("/test")
	public String test() {
		return "welcome to second microservice";
		
	}
	
	@GetMapping("/appUrl")
	public String commonFuncation() {
		
	String url = 	lbc.choose("one").getUri().toString();
	System.out.println("the url is "+url+""+lbc.choose("one").getServiceId());
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
	
	@GetMapping("/empployee/getAll")
	public List<Employee> getAll() {
		
	 List<Employee> empList = new ArrayList<Employee>();
		
	 	empList.add(new Employee(1, "Ashutosh Kumar", "Java", "Developer", "sbi"));
	 	empList.add(new Employee(2, "Prashant Kumar Shekhar", "Java", "Developer", "sbi"));
	 	empList.add(new Employee(3, "Sanjeev Chauhan", "Java", "Developer", "sbi"));
	 	  
		return empList;
		
	}
	
}
