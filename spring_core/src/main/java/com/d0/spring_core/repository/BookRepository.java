package com.d0.spring_core.repository;

import com.d0.spring_core.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public Book save(Book book) {
        System.out.println(book.getTitle() + "을(를) " + book.getCreatedAt() + "에 저장 완료했습니다.");
        return book;
    }
}
