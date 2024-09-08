package com.cpg.register.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thymeleaf.context.Context;

import com.cpg.register.model.Student;

@ExtendWith(SpringExtension.class)
public class DataMapperTest {
 @InjectMocks
 DataMapper dataMapper;
 
 @Test
 void setDataTEst() {
	Context context=new Context();
	Student stud=new Student();
	stud.setName("amar");
    //List<Student> list=new ArrayList<>();
    //list.add(stud);
    Map<String,Object> object=new HashMap<>();
    object.put("student", stud);
	context.setVariables(object);
	dataMapper.setData(stud);
 }
}
