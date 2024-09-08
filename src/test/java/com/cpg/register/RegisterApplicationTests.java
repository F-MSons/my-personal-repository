package com.cpg.register;

import static org.mockito.Mockito.doNothing;

import org.apache.jasper.tagplugins.jstl.core.When;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegisterApplicationTests {
    @InjectMocks
    private RegisterApplication registerApplication;
    
	@Test
	void contextLoads() {
		String[] args= {"abc","12"};
	  RegisterApplication.main(args);
	}

}
