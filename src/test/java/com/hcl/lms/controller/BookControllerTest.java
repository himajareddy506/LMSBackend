package com.hcl.lms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.BookListResponseDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.service.BookServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	@Mock
	BookServiceImpl bookServiceImpl;
	@InjectMocks
	BookController bookController;
	Book book;
	BookDto bookDto;
	ResponseDto responseDto;

	@Before
	public void initiateData() {

		book = new Book();
		book.setBookId(1);
		book.setBookCode(101);
		book.setAuthor("Jyoshna");
		book.setBookName("Java");
		book.setUserId(1);

		bookDto = new BookDto();
		bookDto.setAuthor("xyz");
		bookDto.setBookName("Java");
		bookDto.setUserId(101);

		responseDto = new ResponseDto();
		responseDto.setMessage("Added");
		responseDto.setStatusCode(201);

	}

	@Test
	public void testGetBookList() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(book);
		Mockito.when(bookServiceImpl.getBookList()).thenReturn(bookList);
		ResponseEntity<BookListResponseDto> bookListResponseDto = bookController.getBookList();
		assertNotNull(bookListResponseDto);
		assertEquals(200, bookListResponseDto.getStatusCode().value());

	}

	@Test
	public void saveTest() {
		Mockito.when(bookServiceImpl.save(bookDto)).thenReturn(responseDto);
		ResponseEntity<ResponseDto> actualResult = bookController.save(bookDto);
		assertEquals(201, actualResult.getStatusCode().value());
	}

}
