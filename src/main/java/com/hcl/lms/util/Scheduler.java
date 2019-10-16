package com.hcl.lms.util;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.lms.entity.BorrowDetail;
import com.hcl.lms.repository.BorrowDetailRepository;

/**
 * @author Subashri Sridharan
 *
 */
@Component
public class Scheduler {
	@Autowired
	BorrowDetailRepository borrowDetailRepository;
	/**
	 * Book will be released automatically on the releaseDate 
	 *
	 */

	@Scheduled(cron = "0 0/1 * * * *")
	public void bookReleaseSchedule() {
		List<BorrowDetail> borrowList=borrowDetailRepository.findByReleaseDate(LocalDate.now());
		borrowList.stream().forEach(borrowInfo -> {
<<<<<<< HEAD
			borrowInfo.setStatus(ExceptionConstants.releaseStatus);	
=======
			borrowInfo.setStatus(ExceptionConstants.releaseStatus);		
>>>>>>> df2e5db3217fcc81dc7e6faa385ea87b81ac744e
			borrowDetailRepository.save(borrowInfo);
		});
		}
	}

