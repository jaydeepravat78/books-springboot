package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book addBook(Book book);

    List<Book> getBooks();

    Book updateBook(Book book);

    void deleteBook(long id);

    Optional<Book> getBook(long id);
}
