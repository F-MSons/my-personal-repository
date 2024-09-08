package com.cpg.register.service;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cpg.register.model.Student;
import com.cpg.register.repository.StudentRepository;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {
	@InjectMocks
	private StudentService studentService;
	
	@Mock
	private StudentRepository studentRepository;
	
	private Student student;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);	
	}
	
	@Test
	void testAddStudent()throws Exception {
		student=new Student();
		student.setId(11);
		student.setName("Amar");
	
	doNothing().when(studentRepository).addStudent(anyLong(), anyString(), anyString(),
			anyString(), anyString(), anyString(), anyString(), anyString(), anyString());
	
	studentService.addStudent(student);
	}
	
	@Test
	void testGetAllStudent()throws Exception{
		student=new Student();
		student.setId(11);
		student.setName("Amar");
		List<Student> list=new ArrayList<>();
		Assertions.assertNotNull(studentService.getAllStudent());
	}
	
	@Test
	void testValidateStudent()throws Exception {
		student=new Student();
		student.setId(11);
		student.setName("Amar");
		student.setAge("28");
		student.setCity("pune");
		student.setMobile("897930");
		List<Student> list=new ArrayList<>();
		list.add(student);
		when(studentService.getStudent(student)).thenReturn(list);
		Assertions.assertTrue(studentService.validateStudent(student));
	}
	
	@Test
	void TestRemoveStudent()throws Exception{
		doNothing().when(studentRepository).removeStudent(anyLong());
		studentService.removeStudent(101);
	}
	
	@Test
	void testUpdateStudent()throws Exception {
		student=new Student();
		student.setId(11);
		student.setName("Amar");
		student.setAge("28");
		student.setCity("pune");
     doNothing().when(studentRepository).editStudent(anyLong(), anyString(), anyString(), anyString(), anyString(), anyString());
	 studentService.updateStudent(student);
	}

}
