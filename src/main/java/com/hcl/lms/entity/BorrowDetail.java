package com.hcl.lms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
<<<<<<< HEAD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id

=======

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
>>>>>>> df2e5db3217fcc81dc7e6faa385ea87b81ac744e
	private Integer borrowerId;
	private LocalDate dateOfBorrow;
	private LocalDate releaseDate;
	private Integer bookId;
	private Integer userId;
	private String status;
}
