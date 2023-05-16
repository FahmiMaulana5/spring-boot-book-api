package com.fahmimf.com.apibook.service;


import java.util.List;
import java.util.Optional;

import com.fahmimf.com.apibook.entity.Book;

public interface BookService {
    public void addBook(Book book);
    public List<Book> getAllBook();
    public Optional<Book> getBookById(Long bookId);
    public List<Book> getBookByTitle(String bookTitle);
    public List<Book> getBookByAuthor(String bookAuthor);
    public List<Book> getBookByYear(Integer year);
    public void updateBookById(String bookTitle, String bookAuthor, Integer year, Long id);
    public void deleteBookById(Long bookId);
}
