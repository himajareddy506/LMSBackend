package com.hcl.lms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.BookBorrowResponseDto;
import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.BookRequestDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.entity.BookRequestDetail;
import com.hcl.lms.entity.BorrowDetail;
import com.hcl.lms.repository.BookRepository;
import com.hcl.lms.repository.BookRequestDetailRepository;
import com.hcl.lms.repository.BorrowDetailRepository;

@Service
public class BookServiceImpl implements BookService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookRequestDetailRepository bookRequestDetail;
	@Autowired
	BorrowDetailRepository borrowDetailRepository;

	@Override
	public List<Book> getBookList() {

		LOGGER.info("inside list of books service");
		return bookRepository.findAll();
	}
	
	@Override
	public ResponseDto save(BookDto bookDto) {
		
		Random random = new Random();
		Book book = new Book();
		ResponseDto responseDto = new ResponseDto ();
		BeanUtils.copyProperties(bookDto, book);
		book.setLendDate(LocalDate.now());
		book.setBookCode(random.nextInt(1000));
		bookRepository.save(book);
		responseDto.setMessage("Book Added Successfully");
		responseDto.setStatusCode(200);
		
		return responseDto;
	}

	@Override
	public String requestBook(BookRequestDto bookRequestDto) {
		BookRequestDetail bookRequestrequestDetail = new BookRequestDetail();
		BeanUtils.copyProperties(bookRequestDto, bookRequestrequestDetail);
		bookRequestDetail.save(bookRequestrequestDetail);
		return "Your request has been Submitted";
	}

	@Override
	public BookBorrowResponseDto borrow(BookRequestDto bookRequestDto) {
		BorrowDetail borrowDetail = new BorrowDetail();
		BookBorrowResponseDto borrowResponseDto = new BookBorrowResponseDto ();
		BeanUtils.copyProperties(borrowResponseDto, borrowDetail);
		borrowDetail.setBookId(bookRequestDto.getBookId());
		borrowDetail.setUserId(bookRequestDto.getUserId());
		borrowDetail.setDateOfBorrow(LocalDate.now());
		borrowDetail.setReleaseDate(LocalDate.now().plusDays(3));
		borrowDetail.setStatus("availed");
		borrowDetailRepository.save(borrowDetail);
		borrowResponseDto.setMessage("Book Borroweds Successfully");
		borrowResponseDto.setStatusCode(201);
		
		return borrowResponseDto;
	}

}
