package com.hcl.lms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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
import com.hcl.lms.exception.CommonException;
import com.hcl.lms.repository.BookRepository;
import com.hcl.lms.repository.BookRequestDetailRepository;
import com.hcl.lms.repository.BorrowDetailRepository;
import com.hcl.lms.util.ExceptionConstants;

/**
 * @author Jyoshna, Subashri, Shilendra
 *
 */

@Service
public class BookServiceImpl implements BookService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookRequestDetailRepository bookRequestDetailRepository;
	@Autowired
	BorrowDetailRepository borrowDetailRepository;

	@Override
	public List<Book> getBookList() {
		LOGGER.info("inside list of books service");
		return bookRepository.findAll();
	}

	@Override
	public ResponseDto save(BookDto bookDto) {
		LOGGER.info("inside add book service");
		Book listBook=bookRepository.findByBookNameAndAuthor(bookDto.getBookName(), bookDto.getAuthor());
		if(((listBook.getBookName().equalsIgnoreCase(bookDto.getBookName()))&&(listBook.getAuthor().equalsIgnoreCase(bookDto.getAuthor())))) {
			throw new CommonException(ExceptionConstants.BOOK_EXIST);
		}
		Random random = new Random();
		Book book = new Book();
		ResponseDto responseDto = new ResponseDto();
		BeanUtils.copyProperties(bookDto, book);
		book.setLendDate(LocalDate.now());
		book.setBookCode(random.nextInt(1000));
		bookRepository.save(book);
		responseDto.setMessage("Book Added Successfully");
		responseDto.setStatusCode(200);
		return responseDto;
	}

	@Override
	public Book borrow(BookRequestDto bookRequestDto) {
		LOGGER.info("inside borrow book service");
		BorrowDetail borrow=borrowDetailRepository.findByBookIdAndUserId(bookRequestDto.getBookId(), bookRequestDto.getUserId());
		if(borrow!=null) {
			throw new CommonException(ExceptionConstants.ALREADY_AVAILED);
		}
		BorrowDetail borrowDetail = new BorrowDetail();
		BookBorrowResponseDto borrowResponseDto = new BookBorrowResponseDto();
		BeanUtils.copyProperties(borrowResponseDto, borrowDetail);
		borrowDetail.setBookId(bookRequestDto.getBookId());
		borrowDetail.setUserId(bookRequestDto.getUserId());
		borrowDetail.setDateOfBorrow(LocalDate.now());
		borrowDetail.setReleaseDate(LocalDate.now().plusDays(3));
		borrowDetail.setStatus("availed");
		borrowDetailRepository.save(borrowDetail);
		Optional<Book> book = bookRepository.findById(bookRequestDto.getBookId());
		return book.get();
	}

	@Override
	public Book requestBook(BookRequestDto bookRequestDto) {
		LOGGER.info("inside book request service");
		BookRequestDetail bookRequestrequestDetail = new BookRequestDetail();
		BeanUtils.copyProperties(bookRequestDto, bookRequestrequestDetail);
		bookRequestDetailRepository.save(bookRequestrequestDetail);
		Optional<Book> book = bookRepository.findById(bookRequestDto.getBookId());
		return book.get();
	}

}
