package com.scopeless64.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scopeless64.mvc.models.Book;
import com.scopeless64.mvc.respositories.BookRespository;

@Service

public class BookService {
	private final BookRespository bookRepository;
	
	public BookService(BookRespository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	 // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            Book temp =  optionalBook.get();
             temp.setId(id);
             temp.setTitle(title);
             temp.setDescription(desc);
             temp.setLanguage(lang);
             temp.setNumberOfPages(numOfPages);
             return bookRepository.save(temp);
        } else {
            return null;
    }
    }
    
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
}
