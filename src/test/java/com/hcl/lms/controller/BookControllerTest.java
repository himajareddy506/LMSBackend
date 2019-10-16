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

import com.hcl.lms.dto.AddSummaryInfo;
import com.hcl.lms.dto.AddSummaryResponse;
import com.hcl.lms.dto.BookListResponseDto;
import com.hcl.lms.dto.BookRequestDto;
import com.hcl.lms.dto.BookResponseDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.service.BookServiceImpl;
import com.hcl.lms.service.UserBookSummary;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	@Mock
	BookServiceImpl bookServiceImpl;
	@Mock
	UserBookSummary userBookSummary;
	@InjectMocks
	BookController bookController;
	Book book;
	BookRequestDto bookRequestInfo=new BookRequestDto();
	AddSummaryInfo addSummaryInfo=new AddSummaryInfo();
	List<AddSummaryInfo> addSummaryDetail=new ArrayList<>();
	@Before
	public void initiateData() {
		
		book=new Book();
		book.setBookId(1);
		book.setBookCode(101);
		book.setAuthor("Jyoshna");
		book.setBookName("Java");
		book.setUserId(1);
		bookRequestInfo.setBookId(1);
		bookRequestInfo.setUserId(1);
		addSummaryInfo.setAuthor(book.getAuthor());
		addSummaryInfo.setBookName(book.getBookName());
		addSummaryInfo.setLendDate(book.getLendDate());
		addSummaryDetail.add(addSummaryInfo);
		
		
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
	@Test
	public void testRequestBook() {
		
		Mockito.when(bookServiceImpl.requestBook(Mockito.any())).thenReturn(book);
		ResponseEntity<BookResponseDto> response=bookController.requestBook(bookRequestInfo);
		assertEquals(200,response.getStatusCode().value());
	}
	@Test
	public void testAddSummary() {
		Mockito.when(userBookSummary.addSummaryInfo(Mockito.anyInt())).thenReturn(addSummaryDetail);
		ResponseEntity<AddSummaryResponse> response=bookController.addSummary(1);
		assertNotNull(response);
		assertEquals(200, response.getStatusCode().value());
		
		
	}
}

