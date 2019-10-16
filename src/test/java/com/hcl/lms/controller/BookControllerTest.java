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

import com.hcl.lms.dto.BookListResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.service.BookServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	@Mock
	BookServiceImpl bookServiceImpl;
	@InjectMocks
	BookController bookController;
	Book book;
	
	@Before
	public void initiateData() {
		
		book=new Book();
		book.setBookId(1);
		book.setBookCode(101);
		book.setAuthor("Jyoshna");
		book.setBookName("Java");
		book.setUserId(1);
	}
	
	
	@Test
	public void testGetBookList() {
		List<Book> bookList=new ArrayList<>();
		bookList.add(book);
		Mockito.when(bookServiceImpl.getBookList()).thenReturn(bookList);
		ResponseEntity<BookListResponseDto> bookListResponseDto=bookController.getBookList();
		assertNotNull(bookListResponseDto);
		assertEquals(200, bookListResponseDto.getStatusCode().value());
		
	}
}

