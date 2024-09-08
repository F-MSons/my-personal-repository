package com.cpg.register.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.cpg.register.model.Student;


@Service
public class DataMapper {
	
	public Context setData(Student student) {
		Context context=new Context();
		Map<String,Object> object=new HashMap<>();
		object.put("student", student);
		context.setVariables(object);

		return context;
	}
	
}
