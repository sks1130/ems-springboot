package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.constants.Constants;
import com.ems.entity.Employee;
import com.ems.models.Response;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping(value="/ems")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage() {
		return "****Welcome to the homepage*****";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public Response<String> addEmployee(@RequestParam String name, @RequestParam Integer age,
			@RequestParam String address) {
		Response<String> response = new Response<String>();
		if (name == null || name.isEmpty()) {
			response.setData("Name is mandatory for employee");
			response.setStatus(Constants.FAIL);
			return response;
		}
		Employee emp = new Employee(name, age, address);
		response = employeeService.addEmployee(emp);
		return response;
	}
}
