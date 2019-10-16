package com.hcl.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByBookNameAndAuthor(String bookName, String author);
}
