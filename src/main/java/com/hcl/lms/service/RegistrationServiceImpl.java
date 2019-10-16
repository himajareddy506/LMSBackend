package com.hcl.lms.service;

import java.time.LocalDate;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.RegistrationRequestDto;
import com.hcl.lms.entity.User;
import com.hcl.lms.exception.CommonException;
import com.hcl.lms.repository.UserRepository;
import com.hcl.lms.util.ExceptionConstants;

/**
 * @author Subashri Sridharan
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
		
	@Autowired
	UserRepository userRepository;
	
	/**
	 * @param User FirstName,LastName,EmailID,Password
	 * @return Success Message 
	 *
	 */
	
	public String registerUser(RegistrationRequestDto registrationRequestDto) {
		User user=new User();
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (!registrationRequestDto.getEmailId().matches(regex)) {
			throw new CommonException(ExceptionConstants.EMAIL_INVALID);
		}
		if (Long.toString(registrationRequestDto.getMobileNumber()).length() < 10) {
			throw new CommonException(ExceptionConstants.MOBILE_INVALID);
		}
		String randomPasscode = RandomStringUtils.randomAlphanumeric(5);
		BeanUtils.copyProperties(registrationRequestDto, user);
		user.setDateOfRegistration(LocalDate.now());
		user.setPasscode(randomPasscode);
		userRepository.save(user);
		return "Successfully Registered";
	}
}
