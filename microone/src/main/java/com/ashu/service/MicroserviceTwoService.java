package com.ashu.service;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashu.modal.Employee;

@Component 
@Service
@FeignClient(name="two" )//Service Id of second microservice service
public interface MicroserviceTwoService {

	 @RequestMapping("/empployee/getAll")
	   public Collection<Employee> findAll();
}
