package com.hcl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.lms.dto.RegistrationRequestDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.service.RegistrationService;

/**
 * @author Subashri Sridharan
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	/**
	 * @param User FirstName,LastName,EmailID,Password
	 * @return StatusCode,Message
	 *
	 */

	@PostMapping("/register")
	public ResponseEntity<ResponseDto> registerUser(@RequestBody RegistrationRequestDto registrationRequestDto) {
		ResponseDto responseDto = new ResponseDto();
		String message = registrationService.registerUser(registrationRequestDto);
		responseDto.setMessage(message);
		responseDto.setStatusCode(200);

		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}
}
