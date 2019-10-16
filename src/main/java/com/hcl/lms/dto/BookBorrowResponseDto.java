package com.hcl.lms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookBorrowResponseDto {

	private Integer borrowId;
	private Integer statusCode;
	private String message;
}
