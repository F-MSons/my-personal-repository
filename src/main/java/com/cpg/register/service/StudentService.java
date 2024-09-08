package com.cpg.register.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpg.register.dto.StudentDto;
import com.cpg.register.model.Student;
import com.cpg.register.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	
	public List<Student> getAllStudent(){
		return repository.findAll();
	}

	public void addStudent(Student student) {
		
	repository.addStudent(student.getId(), student.getAge(), student.getCity(), student.getEmail(), 
				student.getGender(), student.getMobile(),  student.getName(), student.getPassword(), student.getRole());
	}

	public boolean validateStudent(Student student1) {
		boolean flag=false;
		List<Student> validate=getStudent(student1);
		if(validate.size()>0) {
			flag=true;
		}
		return flag;
	}
	
	public List<Student> getStudent(Student student1) {
		List<Student> student=repository.validateStudent(student1.getEmail(),student1.getPassword(),student1.getRole());
	    return student;
	}

	public void removeStudent(long studentId) {
		repository.removeStudent(studentId);
		
	}

	public void updateStudent(Student student) {
		repository.editStudent(student.getId(), student.getCity(), student.getEmail(), student.getMobile(), student.getName(), student.getPassword());
	}

}
