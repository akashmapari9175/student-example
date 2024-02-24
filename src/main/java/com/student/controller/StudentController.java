package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		Student saveStudent = service.saveStudent(student);
		return new ResponseEntity<Student>(saveStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> allStudent = service.getAllStudent();
		return new ResponseEntity<List<Student>>(allStudent,HttpStatus.OK);
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		Student studentById = service.getStudentById(id);
		return new ResponseEntity<Student>(studentById,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int idt) {
		service.deleteById(idt);
		return "Student deleted successfully ";
	}
	
}
