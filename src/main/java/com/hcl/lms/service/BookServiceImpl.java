package com.hcl.lms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.entity.Book;
import com.hcl.lms.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getBookList() {
		// TODO Auto-generated method stub
		LOGGER.info("inside list of books service");
		return bookRepository.findAll();
	}

}
