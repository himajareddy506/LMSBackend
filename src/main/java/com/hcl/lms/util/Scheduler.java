package com.hcl.lms.util;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.lms.entity.BorrowDetail;
import com.hcl.lms.repository.BorrowDetailRepository;

@Component
public class Scheduler {
	@Autowired
	BorrowDetailRepository borrowDetailRepository;
	@Scheduled(cron = "0 0/1 * * * *")
	public void bookReleaseSchedule() {
		List<BorrowDetail> borrowList=borrowDetailRepository.findByReleaseDate(LocalDate.now());
	}
}
