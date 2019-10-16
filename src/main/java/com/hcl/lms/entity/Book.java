package com.hcl.lms.entity;

<<<<<<< HEAD
=======
import java.io.Serializable;
>>>>>>> 18358f98703b262a736cb5d7630e82934624cb4d
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
<<<<<<< HEAD
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer bookId;
	
	
	private Integer bookCode;
	
=======
public class Book implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	private Integer bookCode;
>>>>>>> 18358f98703b262a736cb5d7630e82934624cb4d
	private String bookName;
	private String author;
	private LocalDate lendDate;
	private Integer userId;
<<<<<<< HEAD
	
	

=======
>>>>>>> 18358f98703b262a736cb5d7630e82934624cb4d
}
