package com.spring.spring_test;

import com.spring.spring_test.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringTestApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testBookRepository() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }

    @Test
    void contextLoads() {
    }

}
