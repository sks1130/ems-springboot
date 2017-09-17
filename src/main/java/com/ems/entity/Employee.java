/**
 * 
 */
package com.ems.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sachin.srivastava
 *
 */
@Document(collection = "employee")
public class Employee {
	
	public Employee(String name, Integer age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	@Id
	private String _id;
	private String name;
	private Integer age;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}
