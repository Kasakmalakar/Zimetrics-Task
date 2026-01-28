package com.info.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.info.entity.Book;
import com.info.exception.BookNotFoundException;
import com.info.store.BookDao;
@Service
public class BookService {
	 private final BookDao BookDao;
	 public BookService(BookDao store) {
		 this.BookDao = store;
	 }

	    public Book addBook(Book book) {
	        BookDao.add(book);
	        return book;
	    }

	    public Book getBook(int id) {
	        Book book = BookDao.getById(id);
	        if (book == null) {
	            throw new BookNotFoundException("book not found");
	        }
	        return book;
	    }

	    public Book deleteBook(int id) {
	        Book book = BookDao.delete(id);
	        if (book == null) {
	            throw new BookNotFoundException("book not found");
	        }
	        return book;
	    }

	    public List<Book> searchByYear(int year) {
	        return BookDao.getBookByYear(year);
	    }
	    public List<Book> getAll(){
	    	return BookDao.getAll();
	    }
}
