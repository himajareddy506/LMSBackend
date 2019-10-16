package com.hcl.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.lms.dto.BookListResponseDto;
import com.hcl.lms.dto.BookRequestDto;
import com.hcl.lms.dto.BookResponseDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.exception.CommonException;
import com.hcl.lms.service.BookService;
import com.hcl.lms.util.ExceptionConstants;

/**
 * @author Subashri Jyoshna
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class BookController {
	
	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<BookListResponseDto> getBookList() {
		
		BookListResponseDto bookListResponseDto = new BookListResponseDto();
		List<Book> bookList = bookService.getBookList();
		if(bookList==null) {
			throw new CommonException(ExceptionConstants.BOOK_NOT_AVAILABLE);
		}
		bookListResponseDto.setBookList(bookList);
		bookListResponseDto.setMessage("List of Books");
		bookListResponseDto.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(bookListResponseDto, HttpStatus.OK);
	}
	
	/**
	 * @param bookId,userId
	 * @return authorName,bookName,message,statusCode
	 *
	 */
	@PostMapping("/book/request")
	public ResponseEntity<BookResponseDto> requestBook(@RequestBody BookRequestDto bookRequestDto){
		BookResponseDto bookResponse=new BookResponseDto();
		Book bookInfo=bookService.requestBook(bookRequestDto);
		bookResponse.setAuthorName(bookInfo.getAuthor());
		bookResponse.setBookName(bookInfo.getBookName());
		bookResponse.setMessage("Your request for availing the book is submitted successfully");
		bookResponse.setStatusCode(200);
		return new ResponseEntity<>(bookResponse,HttpStatus.OK);
	}
}
