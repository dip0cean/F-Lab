package com.d0.spring_core.service;

import com.d0.spring_core.entity.Book;
import com.d0.spring_core.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
public class BookService {
    private BookRepository bookRepository;

    // IoC > DI > 외부에서 의존성 주입
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        book.setTitle("무라카미 하루키 - 상실의 시대");
        book.setCreatedAt(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("==========================");
        System.out.println("PostConstruct Start!");
        System.out.println("==========================");
    }
}
