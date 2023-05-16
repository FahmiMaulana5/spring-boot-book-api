package com.fahmimf.com.apibook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fahmimf.com.apibook.entity.Book;

import jakarta.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String bookTitle);

    List<Book> findByAuthor(String bookAuthor);
    
    List<Book> findByYear(Integer year);

    @Transactional
    @Modifying
    @Query(value = "UPDATE book SET author = :bookAuthor, title = :bookTitle, year = :year WHERE book_id = :id", nativeQuery = true)
    public void updateBookData(@Param("bookAuthor") String bookAuthor, @Param("bookTitle") String bookTitle, @Param("year") Integer year, @Param("id") Long id);
}
