package com.hcl.lms.dto;

import java.util.List;

import com.hcl.lms.entity.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
	private String bookName;
	private String authorName;
	private String message;
	private Integer statusCode;
	private String Status;
	
}
