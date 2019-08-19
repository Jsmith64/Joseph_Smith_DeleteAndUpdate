package com.scopeless64.mvc.respositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.scopeless64.mvc.models.Book;

@Repository
public interface BookRespository extends CrudRepository<Book, Long> {
	List<Book> findAll();
}
