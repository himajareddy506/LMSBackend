package com.hcl.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.AddSummaryInfo;
import com.hcl.lms.entity.Book;
import com.hcl.lms.repository.BookRepository;

@Service
public class UserBookSummaryImpl implements UserBookSummary {
	@Autowired
	BookRepository bookRepository;
	@Override
	public List<AddSummaryInfo> addSummaryInfo(Integer userId) {
		List<Book> bookList=bookRepository.findAllById(userId);
		AddSummaryInfo addSummary=new AddSummaryInfo();
		List<AddSummaryInfo> summaryInfo=new ArrayList<>();
		for(Book book:bookList) {
			addSummary.setAuthor(book.getAuthor());
			addSummary.setBookName(book.getBookName());
			addSummary.setLendDate(book.getLendDate());
			summaryInfo.add(addSummary);
		}
		return summaryInfo;
	}
	
}
