package com.hcl.lms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import org.springframework.beans.BeanUtils;

<<<<<<< HEAD
import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.ResponseDto;
=======
import com.hcl.lms.dto.BookRequestDto;
>>>>>>> df2e5db3217fcc81dc7e6faa385ea87b81ac744e
import com.hcl.lms.entity.Book;
import com.hcl.lms.entity.BookRequestDetail;
import com.hcl.lms.repository.BookRepository;
import com.hcl.lms.repository.BookRequestDetailRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	@Mock
	BookRequestDetailRepository bookDetailRepository;
	@Mock
	BookRepository bookRepository;
	@InjectMocks
	BookServiceImpl bookServiceImpl;
	Book book=new Book();
<<<<<<< HEAD
	BookDto bookDto;
=======
	BookRequestDto bookRequestInfo=new BookRequestDto();
	BookRequestDetail bookRequest=new BookRequestDetail();
>>>>>>> df2e5db3217fcc81dc7e6faa385ea87b81ac744e
	@Before
	public void initiateDate() {
		book=new Book();
		book.setBookId(1);
		book.setBookCode(101);
		book.setAuthor("Jyoshna");
		book.setBookName("Java");
		book.setUserId(1);
<<<<<<< HEAD
		
		bookDto = new BookDto();
		 bookDto.setAuthor("Shilendra");
		 bookDto.setBookName("java");
		 bookDto.setUserId(1);

=======
		bookRequestInfo.setBookId(1);
		bookRequestInfo.setUserId(1);
		BeanUtils.copyProperties(bookRequestInfo, bookRequest);
>>>>>>> df2e5db3217fcc81dc7e6faa385ea87b81ac744e
	}
	
	@Test
	public void testGetBookList() {
		List<Book> bookList=new ArrayList<>();
		bookList.add(book);
		Mockito.when(bookRepository.findAll()).thenReturn(bookList);
		List<Book> bookInfo=bookServiceImpl.getBookList();
		assertNotNull(bookInfo);		
	}
<<<<<<< HEAD
	
	@Test
	public void addbookTest() {
	 
	 Mockito.when(bookRepository.save(Mockito.anyObject())).thenReturn(Mockito.anyObject());
	 
	 ResponseDto responseDto = bookServiceImpl.save(bookDto);
	 
	 assertEquals("Book Added Successfully", responseDto.getMessage());
	 
	}

=======
	@Test
	public void testRequestUser() {
		Optional<Book> bookInfo=Optional.of(book);
		Mockito.when(bookDetailRepository.save(Mockito.any())).thenReturn(bookRequest);
		Mockito.when(bookRepository.findById(Mockito.anyInt())).thenReturn(bookInfo);
		Book bookDetail=bookServiceImpl.requestBook(bookRequestInfo);
		assertNotNull(bookDetail);
		assertEquals("Java",bookDetail.getBookName());
	}
>>>>>>> df2e5db3217fcc81dc7e6faa385ea87b81ac744e
}
