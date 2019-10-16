package com.hcl.lms.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.lms.dto.RegistrationRequestDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.service.RegistrationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {
	
	@Mock
	RegistrationServiceImpl registrationService;
	@InjectMocks
	RegistrationController registrationController;
	RegistrationRequestDto requestDto=new RegistrationRequestDto();
	String message="";
	@Before
	public void initData() {
		
		
		requestDto.setEmailId("subashri@gmail.com");
		requestDto.setFirstName("Subashri");
		requestDto.setLastName("Sridharan");
		requestDto.setMobileNumber(98765432109L);
		message="Successfully Registered";
		
	}
	@Test
	public void testRegisterUser() {
		Mockito.when(registrationService.registerUser(Mockito.any())).thenReturn(message);
		ResponseEntity<ResponseDto> response =registrationController.registerUser(requestDto);
		assertEquals(201, response.getStatusCode().value());
	}
}
