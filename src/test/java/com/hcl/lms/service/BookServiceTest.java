package com.hcl.lms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import com.hcl.lms.dto.BookBorrowResponseDto;
import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.BookRequestDto;
import com.hcl.lms.dto.BookResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.entity.BookRequestDetail;
import com.hcl.lms.entity.BorrowDetail;
import com.hcl.lms.repository.BookRepository;
import com.hcl.lms.repository.BookRequestDetailRepository;
import com.hcl.lms.repository.BorrowDetailRepository;

/**
 * @author Jyoshna, Subashri, Shilendra
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceTest.class);

	@Mock
	BookRequestDetailRepository bookRequestDetailRepository;

	@Mock
	BorrowDetailRepository borrowDetailRepository;

	@Mock
	BookRepository bookRepository;

	@InjectMocks
	BookServiceImpl bookServiceImpl;

	Book book;

	BookDto bookDto;

	BorrowDetail borrowDetail;

	BookRequestDto bookRequestDto;

	BookRequestDetail bookRequest;

	BookRequestDto bookRequest1;

	BookBorrowResponseDto borrowResponseDto;

	@Before
	public void initiateDate() {
		bookRequest = new BookRequestDetail();
		book = new Book();
		book.setBookId(1);
		book.setBookCode(101);
		book.setAuthor("Jyoshna");
		book.setBookName("Java");
		book.setUserId(1);

		bookDto = new BookDto();
		bookDto.setAuthor("Shilendra");
		bookDto.setBookName("java");
		bookDto.setUserId(1);

		bookRequestDto = new BookRequestDto();
		bookRequestDto.setBookId(1);
		bookRequestDto.setUserId(1);
		BeanUtils.copyProperties(bookRequestDto, bookRequest);

		borrowDetail = new BorrowDetail();
		borrowDetail.setBookId(1);
		borrowDetail.setBorrowerId(1);
		borrowDetail.setStatus("Book Borrowed Successfully");
		borrowDetail.setDateOfBorrow(LocalDate.now());
		borrowDetail.setReleaseDate(LocalDate.now().plusDays(3));
		borrowDetail.setStatus("availed");

	}

	@Test
	public void testGetBookList() {
		LOGGER.info("inside list of books service test");
		List<Book> bookList = new ArrayList<>();
		List<BorrowDetail> borrowList=new ArrayList<>();
		borrowList.add(borrowDetail);
		bookList.add(book);
		Mockito.when(bookRepository.findAll()).thenReturn(bookList);
		Mockito.when(borrowDetailRepository.findByBookId(Mockito.anyInt())).thenReturn(borrowList);
		List<BookResponseDto> bookResponse = bookServiceImpl.getBookList();
		assertNotNull(bookResponse);
	}

	@Test
	public void testBorrow() {
		LOGGER.info("inside borrow book service test");
		Optional<Book> bookInfo = Optional.of(book);
		Mockito.when(borrowDetailRepository.save(Mockito.any())).thenReturn(borrowDetail);
		Mockito.when(bookRepository.findById(Mockito.anyInt())).thenReturn(bookInfo);
		BookBorrowResponseDto bookDetail = bookServiceImpl.borrow(bookRequestDto);
		assertNotNull(bookDetail);
		assertEquals("Java", bookDetail.getBookName());
	}

	@Test
	public void testRequestBook() {
		LOGGER.info("inside book request service");
		Optional<Book> bookInfo = Optional.of(book);
		Mockito.when(bookRequestDetailRepository.save(Mockito.any())).thenReturn(bookRequest);
		Mockito.when(bookRepository.findById(Mockito.anyInt())).thenReturn(bookInfo);
		Book bookDetail = bookServiceImpl.requestBook(bookRequestDto);
		assertNotNull(bookDetail);
		assertEquals("Java", bookDetail.getBookName());
	}

}
