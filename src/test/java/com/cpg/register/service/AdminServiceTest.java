package com.cpg.register.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cpg.register.repository.AdminRepository;

@ExtendWith(SpringExtension.class)
public class AdminServiceTest {
	
	@InjectMocks
	private AdminService service;
	@Mock
	private AdminRepository repository;
	
	@Test
	void testRemoveStudent() {
		doNothing().when(repository).deleteById(anyLong());
		service.removeStudent(102);
	}

}
