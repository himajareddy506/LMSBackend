package com.hcl.lms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.BookRequestDto;
import com.hcl.lms.entity.Book;
import com.hcl.lms.entity.BookRequestDetail;
import com.hcl.lms.repository.BookRepository;
import com.hcl.lms.repository.BookRequestDetailRepository;

@Service
public class BookServiceImpl implements BookService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookRequestDetailRepository bookRequestDetail;

	@Override
	public List<Book> getBookList() {
		
		LOGGER.info("inside list of books service");
		return bookRepository.findAll();
	}

	@Override
	public String requestBook(BookRequestDto bookRequestDto) {
		BookRequestDetail bookRequestrequestDetail=new BookRequestDetail();
		BeanUtils.copyProperties(bookRequestDto, bookRequestrequestDetail);
		bookRequestDetail.save(bookRequestrequestDetail);
		return "Your request has been Submitted";
	}

}
