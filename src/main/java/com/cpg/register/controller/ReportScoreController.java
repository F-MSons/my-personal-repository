package com.cpg.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.cpg.register.model.Student;
import com.cpg.register.model.Test;
import com.cpg.register.service.DataMapper;
import com.cpg.register.service.ETestService;
import com.cpg.register.service.ReportGenerator;
import com.cpg.register.service.StudentService;


@RestController
@RequestMapping("/api")
public class ReportScoreController {
	@Autowired
	private ReportGenerator reportGenerator;
	@Autowired
	private SpringTemplateEngine springTemplateEngine;
	@Autowired
	private DataMapper dataMapper;
	@Autowired
	private ETestService testService;
	
	@PostMapping("/generate/report")
	public String generateReport(@ModelAttribute Student student, Model model,@ModelAttribute Test test) {
		//List<Student> student=service.getStudent(student);
		//student = service.getAllStudent();
		student.setScore(testService.getScore(test));
		String finalHtml=null;
		Context dataContext=dataMapper.setData(student);
		finalHtml=springTemplateEngine.process("score_report", dataContext);
		reportGenerator.htmlToPdf(finalHtml);
		
		return "report-downloaded..";
	}
	
	/*
	 * @GetMapping("/generate/report") public String getReport() { return
	 * "test_score"; }
	 */
}
