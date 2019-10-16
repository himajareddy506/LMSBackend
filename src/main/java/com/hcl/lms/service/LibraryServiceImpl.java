package com.hcl.lms.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public ResponseDto save(BookDto bookDto) {
		
		Random random = new Random();
		Book book = new Book();
		ResponseDto responseDto = new ResponseDto ();
		BeanUtils.copyProperties(bookDto, book);
		book.setLendDate(LocalDate.now());
		book.setBookCode(random.nextInt(1000));
		libraryRepository.save(book);
		responseDto.setMessage("added");
		responseDto.setStatusCode(200);
		
		return responseDto;
	}

}
