package com.hcl.lms.service;

import java.util.List;

import com.hcl.lms.dto.BookRequestDto;
import com.hcl.lms.entity.Book;


public interface BookService {

	public List<Book> getBookList();
	public Book requestBook(BookRequestDto bookRequestDto);
}
