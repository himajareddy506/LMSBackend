package com.hcl.lms.service;



import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.ResponseDto;


public interface LibraryService {

	public  ResponseDto save (BookDto bookDto);

}
