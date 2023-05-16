package com.fahmimf.com.apibook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fahmimf.com.apibook.dto.Response;
import com.fahmimf.com.apibook.entity.Book;
import com.fahmimf.com.apibook.service.impl.BookServiceImpl;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book){
        bookService.addBook(book);
        Response response = new Response(HttpStatus.OK.value(), "Book Added Succesfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity getAllBook(){
        List<Book> books = bookService.getAllBook();
        return ResponseEntity.ok(books);
    }

    @GetMapping
    @RequestMapping("/id")
    public ResponseEntity getBookById(@RequestParam Long id){
        Optional<Book> books = bookService.getBookById(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping
    @RequestMapping("/title")
    public ResponseEntity getBookByTitle(@RequestParam String title){
        List<Book> books = bookService.getBookByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping
    @RequestMapping("/author")
    public ResponseEntity getBookByAuthor(@RequestParam String author){
        List<Book> books = bookService.getBookByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping
    @RequestMapping("/year")
    public ResponseEntity getBookByYear(@RequestParam Integer year){
        List<Book> books = bookService.getBookByYear(year);
        return ResponseEntity.ok(books);
    }

    @PutMapping
    public ResponseEntity updateBookData(@RequestParam Long id, @RequestBody Book book){
        bookService.updateBookById(book.getTitle(), book.getAuthor(), book.getYear(), id);
        Response response = new Response(HttpStatus.OK.value(), "Book Updated Succesfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestParam Long id){
        bookService.deleteBookById(id);
        Response response = new Response(HttpStatus.OK.value(), "Book Deleted Succesfully");
        return ResponseEntity.ok(response);
    }
}
