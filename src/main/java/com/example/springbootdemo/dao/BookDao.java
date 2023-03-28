package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookDao extends JpaRepository<Book, Long> {
}
