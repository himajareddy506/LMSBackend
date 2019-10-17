package com.hcl.lms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.lms.dto.BookBorrowResponseDto;
import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.BookRequestDto;
import com.hcl.lms.dto.BookResponseDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.service.BookService;

/**
 * @author Jyoshna, Subashri, Shilendra
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<BookResponseDto>> getBookList() {
		logger.info("inside book list controller");
		List<BookResponseDto> bookList= bookService.getBookList();
		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}

	@PostMapping("/book/add")
	public ResponseEntity<ResponseDto> save(@RequestBody BookDto bookDto) {
		logger.info("inside add book controller");
		return new ResponseEntity<>(bookService.save(bookDto), HttpStatus.CREATED);

	}
	
	@PostMapping("/book/borrow")
	public ResponseEntity<BookBorrowResponseDto> borrow(@RequestBody BookRequestDto bookRequestDto) {
		logger.info("inside borrow book controller");
		BookBorrowResponseDto borrowResponse = bookService.borrow(bookRequestDto);
		return new ResponseEntity<>(borrowResponse, HttpStatus.CREATED);

	}

	/**
	 * @param bookId,userId
	 * @return authorName,bookName,message,statusCode
	 *
	 */

	@PostMapping("/book/request")
	public ResponseEntity<BookResponseDto> requestBook(@RequestBody BookRequestDto bookRequestDto) {
		logger.info("inside request book controller");
		BookResponseDto bookResponse = new BookResponseDto();
		Book bookInfo = bookService.requestBook(bookRequestDto);
		bookResponse.setAuthorName(bookInfo.getAuthor());
		bookResponse.setBookName(bookInfo.getBookName());
		bookResponse.setMessage("Your request for availing the book is submitted successfully");
		bookResponse.setStatusCode(200);
		return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
	}

}
