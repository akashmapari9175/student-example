package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public Student saveStudent(Student student) {
		Student save = studentRepo.save(student);
		return save;
	}
	
	public List<Student> getAllStudent(){
		List<Student> findAll = studentRepo.findAll();
		return findAll;
	}
	
	public Student getStudentById(int id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}
	
	
	public Student updateStudentById(int id,Student student) {
		Student student2 = studentRepo.findById(id).get();
		student2.setLastName(student.getLastName());
		student2.setName(student.getName());
		student2.setAddress(student.getAddress());
		Student updateStudent = studentRepo.save(student2);
		return updateStudent;
	}
	
	public void deleteById(int id) {
		studentRepo.deleteById(id);
	}
	
	
}
