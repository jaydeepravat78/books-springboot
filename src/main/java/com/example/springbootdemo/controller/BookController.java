package com.example.springbootdemo.controller;


import com.example.springbootdemo.entity.Book;
import com.example.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping("/")
    public List<Book> getBooks() {
        return  bookService.getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable long id) {
        try {
            if(bookService.getBook(id).isEmpty())
                return new ResponseEntity<>("Id not found", HttpStatus.SERVICE_UNAVAILABLE);
            else
                return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?>  addBook(@RequestBody Book book) {
        try {
            return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        try {
            return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id) {
        if(bookService.getBook(id).isEmpty())
            return new ResponseEntity<>("Please enter a valid id",HttpStatus.BAD_REQUEST);
        else {
            try {
                bookService.deleteBook(id);
                return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
            }
        }
    }

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello", new HttpHeaders(),HttpStatus.OK);
    }

}
