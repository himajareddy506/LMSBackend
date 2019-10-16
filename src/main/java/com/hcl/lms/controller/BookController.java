package com.hcl.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.hcl.lms.dto.BookBorrowResponseDto;
import com.hcl.lms.dto.BookDto;
=======
import com.hcl.lms.dto.AddSummaryInfo;
import com.hcl.lms.dto.AddSummaryResponse;
>>>>>>> df2e5db3217fcc81dc7e6faa385ea87b81ac744e
import com.hcl.lms.dto.BookListResponseDto;
import com.hcl.lms.dto.BookRequestDto;
import com.hcl.lms.dto.BookResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.exception.CommonException;
import com.hcl.lms.service.BookService;
import com.hcl.lms.service.UserBookSummary;
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
	@Autowired
	UserBookSummary userBookSummary;

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
	
	@PostMapping("/book/add")
	public ResponseEntity<ResponseDto> save(@RequestBody BookDto bookDto) {

		return new ResponseEntity<>(bookService.save(bookDto), HttpStatus.CREATED);

	
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
	@GetMapping("/book/{userId}/lendSummary")
	public ResponseEntity<AddSummaryResponse> addSummary(@PathVariable("userId") Integer userId){
		AddSummaryResponse addSummaryInfo=new AddSummaryResponse();
		List<AddSummaryInfo> summaryInfo=userBookSummary.addSummaryInfo(userId);
		addSummaryInfo.setAddedBookInfo(summaryInfo);
		addSummaryInfo.setMessage("Added BookSummary");
		addSummaryInfo.setStatusCode(200);
		return new ResponseEntity<AddSummaryResponse>(addSummaryInfo,HttpStatus.OK);
	}
	
	@PostMapping("/book/borrow")
	public ResponseEntity<BookBorrowResponseDto> borrow(@RequestBody BookRequestDto bookRequestDto) {

		return new ResponseEntity<>(bookService.borrow(bookRequestDto), HttpStatus.CREATED);

	
	}
}
