package com.d0.spring_core.service;

import com.d0.spring_core.entity.Book;
import com.d0.spring_core.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {

    @Test
    public void save() {
        // 외부에서 BookRepository 구현체 정의
        BookRepository bookRepository = new BookRepository();
        // BookService 에 필요한 의존성을 외부에서 생성한 구현체를 주입한다.
        BookService bookService = new BookService(bookRepository);

        // 엔티티 생성
        Book book = new Book();
        assertThat(book.getCreatedAt()).isNotNull();
        assertThat(book.getTitle()).isNotNull();
        Book result = bookService.save(book);
        assertThat(result).isNotNull();


        /*
            - BookRepository, BookService
                > Spring Bean
                    > IoC Container 를 통해 관리되는 싱글톤 객체
                        > 공장의 역할을 하는데, 여러 개 만들 필요가 있을까?
            - Book
                > POJO (Getter, Setter)
                    > Spring Bean 으로 관리되면 안된다.
                    Entity 객체는 구성요소가 시시각각 변하기 때문에.

            - SingleTon Pattern
                > 단 하나의 구현체만 존재하도록 하는 디자인 패턴
                > 한 번만 만들기 때문에 자원의 낭비를 막을 수 있다.
                > 의존성 관리를 할 수 있다.
                > 라이프 사이클 - Spring Bean 에 한하여
                    > 스코프
                    > 라이프 사이클 인터페이스
                    > @PostConstruct ?
            - ProtoType Pattern
                > 요청이 올 때 마다 새로운 구현체를 생성한다.
         */
    }

    @Mock
    private BookRepository bookRepository;

    @Test
    public void mockSave() {
        Book book = new Book();

        Mockito.when(bookRepository.save(book)).thenReturn(book);
        BookService bookService = new BookService(bookRepository);

        Book result = bookService.save(book);
        assertThat(book.getCreatedAt()).isNotNull();
        assertThat(book.getTitle()).isNotNull();
        assertThat(result).isNotNull();
    }

    @Test
    public void postConstruct() {
        /*
            Spring Boot 5.x 부터 @RunWith 어노테이션이 사라졌다.
            별도로 @ExtendWith 를 사용 할 수 있지만, @SpringBootTest 어노테이션 자체적으로
            @ExtendWith(SpringExtension.class) 를 가지고 있는 것과 같은 의미를 가진다.
         */
    }
}
