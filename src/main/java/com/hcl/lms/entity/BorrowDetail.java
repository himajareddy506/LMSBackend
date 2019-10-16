package com.hcl.lms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class BorrowDetail {
	private Integer borrowerId;
	private LocalDate dateOfBorrow;
	private LocalDate releaseDate;
	private Integer bookId;
	private Integer userId;
}
