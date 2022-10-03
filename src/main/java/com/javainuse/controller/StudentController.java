package com.javainuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Student;

@RestController
public class StudentController  implements CommandLineRunner  {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	List<Student> students;


	//Get annotation for Get Method
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
	public List<Student> secondPage() {
		return students;
	}
	
	//Delete annotation for Delete Method
		@DeleteMapping(path = { "student/{id}" })
		public Student deleteStudent(@PathVariable("id") int id) {
			Student deletedStd = null;
			for (Student emp : students) {
				if (emp.getSv_id().equals(id)) {
					students.remove(emp);
					deletedStd = emp;
					break;
				}
			}
			return deletedStd;
		}

		@PutMapping("student/")
		public Student updateStudent (@PathVariable Long id, @RequestBody Student std) {
			for (Student emp : students) {
				if (emp.getSv_id().equals(id)) {
					students.remove(emp);
					std.setSv_id(id);
					students.add(std);
					break;
				}
			}
			return std;
		}
		
		//Post annotation for Post Method
		@PostMapping("student/{id}")
		public Student createStudent(@RequestBody Student std) {
			students.add(std);
			System.out.println(students);
			return std;
			
		}

		
	private  List<Student> createListStudent() {
		String sql ="Select * from AA_KEN_SINHVIEN ";
		 students = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(Student.class));
		
		return students;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 students= createListStudent();
	}
}