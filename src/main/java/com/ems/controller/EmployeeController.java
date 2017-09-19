package com.ems.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.config.EmployeeManagement;
import com.ems.constants.Constants;
import com.ems.entity.Employee;
import com.ems.models.Response;
import com.ems.service.EmployeeService;

/**
 * 
 * @author sachin
 *This is Employee Controller of all the methods related Employee Add/Update/Delete
 */
@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage() {
		return "****Welcome to the homepage*****";
	}

	@RequestMapping(value = "/addOrUpdateEmployee", method = RequestMethod.GET)
	public Response<String> addOrUpdateEmployee(@RequestParam String name, @RequestParam Integer age,
			@RequestParam String address) {
		Response<String> response = new Response<String>();
		try {
			if (name == null || name.isEmpty()) {
				response.setData("Name is mandatory for employee");
				response.setStatus(Constants.FAIL);
				return response;
			}
			Employee emp = new Employee(name, age, address);
			response = employeeService.addOrUpdateEmployee(emp);// if employee
																// doesn't exist
																// then insert
																// otherwise
																// update the
																// emmployee
			response.setStatus(Constants.SUCCESS);
			response.setData("Employee saved: " + emp.toString());
		} catch (Exception e) {
			logger.error("error :" + e.getMessage());
			response.setData(e.getMessage());
			response.setStatus(Constants.ERROR);
		}
		return response;
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public Response<String> deleteEmployee(@RequestParam String id) {
		Response<String> response = new Response<String>();
		try {
			if (id == null || id.isEmpty()) {
				response.setData("id is mandatory for employee");
				response.setStatus(Constants.FAIL);
				return response;
			}
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			employeeService.delete(query, Employee.class);// delete an employee
			response.setData("Employee deleted with id: " + id);
			response.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			logger.error("error:" + e.getMessage());
			response.setStatus(Constants.ERROR);
			response.setData(e.getMessage());
		}
		return response;
	}
	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public Response<List<Employee>> getAllEmployee() {
		Response<List<Employee>> response = new Response<List<Employee>>();
		try {
			List<Employee> empList = employeeService.findAll(Employee.class);
			response.setData(empList);
			response.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			logger.error("error:" + e.getMessage());
			response.setStatus(Constants.ERROR);
		}
		return response;
	}
}
