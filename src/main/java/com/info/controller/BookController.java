package com.info.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.entity.Book;
import com.info.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private BookService service;
  public BookController(BookService service) {
	  this.service = service;
  }
  @PostMapping
  public ResponseEntity<Book> addBook( @RequestBody Book book){
	  return ResponseEntity.status(201).body(service.addBook(book));
  }
  @GetMapping("/{id}")
  public ResponseEntity<Book> getBookById( @PathVariable int id){
	  return ResponseEntity.ok().body(service.getBook(id));
  }
  @GetMapping("/search")
  public ResponseEntity<List<Book>> getBookByYear( @RequestParam int year){
	  return ResponseEntity.ok().body(service.searchByYear(year));
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Book> deleteBook(@PathVariable int id){
	  return ResponseEntity.ok().body(service.deleteBook(id));
  }
  @GetMapping
  public ResponseEntity<List<Book>> getAll(){
	  return ResponseEntity.ok().body(service.getAll());
  }
}
