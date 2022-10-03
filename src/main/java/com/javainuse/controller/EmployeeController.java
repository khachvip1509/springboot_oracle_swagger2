package com.javainuse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;
import com.javainuse.model.Student;
import com.javainuse.model.User;
@RestController
public class EmployeeController  implements CommandLineRunner  {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	private List<Employee> employees ;

	//Get annotation for Get Method
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		return employees;
	}
	

	//Delete annotation for Delete Method
	@DeleteMapping(path = { "employee/{id}" })
	public Employee deleteEmployee(@PathVariable("id") int id) {
		Employee deletedEmp = null;
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id)) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}
	
	//Delete annotation for Delete Method
		@DeleteMapping(path = { "employee/" })
		public void deleteAllEmployee() {
			
			for (Employee emp : employees) {
				employees.remove(emp);
			}
		}
		
	@PutMapping("employee/{id}")
	public Employee updateEmployee (@PathVariable Long id, @RequestBody Employee employee) {
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id)) {
				employees.remove(emp);
				employee.setEmpId(id);
				employees.add(employee);
				break;
			}
		}
		return employee;
	}

	//Post annotation for Post Method
	@PostMapping
	public Employee createEmployee(@RequestBody Employee user) {
		employees.add(user);
		System.out.println(employees);
		return user;
		
	}

	//Initial data
	private  List<Employee> createList() {
		String sql ="Select * from AA_KEN_EMPLOYEE ";
		employees = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(Employee.class));
		
		return employees;
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 employees = createList();
	}
}