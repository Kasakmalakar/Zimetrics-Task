package com.info.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.info.entity.Book;
import com.info.exception.BookAlreadyExistException;
@Component
public class BookDao {
	private final List<Book> books = new ArrayList<>();

	public Book add(Book book) {
		// Check for duplicate ID
		for (Book b : books) {
			if (b.getId() == book.getId()) {
				throw new BookAlreadyExistException("book already exist");
			}
		}
		books.add(book);
		return book;
	}

	public Book getById(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	public Book delete(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				books.remove(book);
				return book;
			}
		}
		return null;
	}

	public List<Book> getBookByYear(int year) {
		List<Book> bookList = new ArrayList<>();
		for(Book book:books) {
			if(book.getYear() == year) {
				bookList.add(book);
			}
		}
		return bookList;
	}
	public List<Book> getAll(){
		return books;
	}
}
