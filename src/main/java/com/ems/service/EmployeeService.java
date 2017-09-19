package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ems.constants.Constants;
import com.ems.dao.MongoDAO;
import com.ems.entity.Employee;
import com.ems.models.Response;
/**
 * 
 * @author sachin.srivastava
 * This the is the service layer of the execution of Employee related actions and services
 * This layer is integrated with the DAO layer for all the DB related activity
 *
 */
@Service
public class EmployeeService {

	@Autowired
	MongoDAO mongoDAO;

	public Response<String> addOrUpdateEmployee(Employee emp) {
		Response<String> response = new Response<String>();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(emp.getName()));
			Employee employee = mongoDAO.findOne(query, Employee.class);
			if (employee == null) {
				mongoDAO.insert(emp);
				response.setData("Employee added: " + emp.toString());
			} else {
				employee.setName(emp.getName());
				employee.setAge(emp.getAge());
				employee.setAddress(emp.getAddress());
				mongoDAO.save(employee);
				response.setData("Employee updated:" + employee.toString());
			}
			response.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			response.setData(e.getMessage());
			response.setStatus(Constants.ERROR);
		}
		return response;
	}


	public String deleteEmployee(Employee emp) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(emp.get_id()));
		mongoDAO.delete(query, Employee.class);
		return "Employee deleted: " + emp.toString();
	}

	public <T> List<T> findAll(Class<T> entityClass) {
		return mongoDAO.findAll(entityClass);
	}

	public <T> List<T> findAll(Query query, Class<T> entityClass) {
		return mongoDAO.find(query, entityClass);
	}
	public <T> T findOne(Query query, Class<T> entityClass) {
		return mongoDAO.findOne(query, entityClass);
	}
	public <T> void delete(Query query , Class<T> entityClass)  {
		mongoDAO.delete(query, entityClass);
	}
}

