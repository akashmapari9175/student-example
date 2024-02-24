package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		return new ResponseEntity<Student>(saveStudent,HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> allStudent = service.getAllStudent();
		return new ResponseEntity<List<Student>>(allStudent,HttpStatus.OK);
	}
	
	
}
