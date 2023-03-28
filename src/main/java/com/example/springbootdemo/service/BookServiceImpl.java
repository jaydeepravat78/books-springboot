package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.BookDao;
import com.example.springbootdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public Book addBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public void deleteBook(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public Optional<Book> getBook(long id) {
        return bookDao.findById(id);
    }
}
