package com.fahmimf.com.apibook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahmimf.com.apibook.entity.Book;
import com.fahmimf.com.apibook.repository.BookRepository;
import com.fahmimf.com.apibook.service.BookService;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long bookId) {
       Optional<Book> books = bookRepository.findById(bookId);
       return books;
    }

    @Override
    public List<Book> getBookByTitle(String bookTitle) {
      List<Book> books = bookRepository.findByTitle(bookTitle);
      return books;
    }

    @Override
    public List<Book> getBookByAuthor(String bookAuthor) {
        List<Book> books = bookRepository.findByAuthor(bookAuthor);
        return books;
    }

    @Override
    public List<Book> getBookByYear(Integer year) {
        List<Book> books = bookRepository.findByYear(year);
        return books;
    }

    @Override
    public void updateBookById(String bookTitle, String bookAuthor, Integer year, Long id) {
        bookRepository.updateBookData(bookAuthor, bookTitle, year, id);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
    
}
