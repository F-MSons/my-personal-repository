package com.cpg.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpg.register.model.Student;
import com.cpg.register.service.AdminService;
import com.cpg.register.service.StudentService;

@Controller
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService service;
	@Autowired
	private AdminService service1;
	
	@GetMapping("/")
	public String home() {
	//	ModelAndView model=new ModelAndView("home");
		return "home";
	}
	
	/*
	 * @GetMapping("/student/all") public List<Student> getAllStudent(){
	 * List<Student> students=service.getAllStudent(); return students; }
	 */
	@GetMapping("/student/all")
	public String getAllStudent(Model model){
		List<Student> students=service.getAllStudent();
		model.addAttribute("students", students);
		return "studentRecords";
	}

	@GetMapping("/register")
	public String showForm(@ModelAttribute Student student) {
		return "registerForm";
	}
	
	@PostMapping("/add")
	//@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute Student student) {
		service.addStudent(student);
		return "success";
	}
	@GetMapping("/login")
	public String showForm(Model model) {
		return "log_in";
	}
	@PostMapping("/profile")
	public String getLogin(@ModelAttribute Student student1, Model model) {
		boolean flag=false;
		List<Student> students=service.getStudent(student1);
		model.addAttribute("students", students);
		if(student1.getRole()!=null) {
			if(student1.getRole().equals("admin")) {
				flag=service.validateStudent(student1);
				  if(flag==true) {
				   return "aprofile";
				   }else {
				  return "error_pwd";
				}		
			}else if(student1.getRole().equals("student")) {
				flag=service.validateStudent(student1);
				  if(flag==true) {
			    return "sprofile";
				  }else {
					  return "error_pwd";
			           }
			}else {
			return "error_pwd";
			}
		}else {
			 return "no_user";
		   }
	}
	@GetMapping("/profile")
	public String adminProfile() {
		return "aprofile";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "log_in";
	}
	
	@GetMapping("/delete/{id}")
    public String removeRecord(@PathVariable("id") long id, Model model) {
		service1.removeStudent(id);
		return "redirect:/api/student/all";
	}
	
	@PutMapping("/edit/{id}")
	public String updateStudent(@ModelAttribute Student student) {
		service.updateStudent(student);
		return "success";
	}
	
	/*
	 * @PutMapping("/edit/{studentId}") public String
	 * editStudent(@PathVariable("studentId") int studentId, Model model) {
	 * service.editStudent(studentId); return "Student removed"; }
	 */
}
