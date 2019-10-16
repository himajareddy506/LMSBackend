package com.hcl.lms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.lms.entity.BorrowDetail;

public interface BorrowDetailRepository extends JpaRepository<BorrowDetail, Integer> {
	List<BorrowDetail> findByReleaseDate(LocalDate date);
}
