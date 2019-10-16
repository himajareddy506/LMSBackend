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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
>>>>>>> 83f0386b3cbd3650a8557c2f552e53e4e3a82f7e
	private Integer borrowerId;
	private LocalDate dateOfBorrow;
	private LocalDate releaseDate;
	private Integer bookId;
	private Integer userId;
	private String status;
}
