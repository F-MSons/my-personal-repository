package com.cpg.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cpg.register.model.Etest;
import com.cpg.register.model.Student;
import com.cpg.register.model.Test;
import com.cpg.register.service.ETestService;

@Controller
@RequestMapping("/api")
public class ETestController {
	@Autowired
	private ETestService testService;

    private Student stud;	
	@GetMapping("/test")
	public String getData(Model model) {
		List<Etest> tests=testService.getData();
		model.addAttribute("tests", tests);
		return "exam_test";
	}
  
	@GetMapping("/sprofile")
	public String getBack() {
		return "sprofile";
	}
	
	@PostMapping("/score")
	public String getScore(@ModelAttribute Test test,Model model) {
		int score=testService.getScore(test);
		if(score>=70) {
		model.addAttribute("score", score);
		return "test_score";
		}else {
			model.addAttribute("score", score);
			return "test_score_fail";
		}
	}
	@GetMapping("question/all")
	public String getAllQuestion(Model model) {
		List<Etest> tests=testService.getData();
		model.addAttribute("tests", tests);
		return "test_record";
	}
}
