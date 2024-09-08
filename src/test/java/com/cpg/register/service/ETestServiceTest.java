package com.cpg.register.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cpg.register.model.Etest;
import com.cpg.register.repository.ETestRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ExtendWith(SpringExtension.class)
public class ETestServiceTest {
	@InjectMocks
	private ETestService service;
	@Mock
	private ETestRepository repository;
	@Mock 
	private Test test;
	
	
	@Test
	void testGetData()throws Exception{
		Etest test=new Etest();
		test.settID(112);
		test.settName("abs");
		List<Etest> list=new ArrayList<>();
		when(repository.findAll()).thenReturn(list);
		assertNotNull((List<Etest>)service.getData());
	}
	
	@Test
	void getScore1()throws Exception {
		com.cpg.register.model.Test test=new com.cpg.register.model.Test();
		test.setTest1("true");
		test.setTest2("true");
		test.setTest3("true");
		test.setTest4("true");
		test.setTest5("true");
		service.getScore(test);
	}
	
	@Test
	void getScore2()throws Exception {
		com.cpg.register.model.Test test=new com.cpg.register.model.Test();
		//test.setTest1("false");
		service.getScore(test);
	}

}
