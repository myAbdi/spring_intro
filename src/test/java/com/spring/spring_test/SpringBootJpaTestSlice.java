package com.spring.spring_test;

import com.spring.spring_test.domain.Book;
import com.spring.spring_test.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.spring.spring_test.bootstrap"})
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Commit
    @Order(1)
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        bookRepository.save(new Book("5050","my book", "self publishing"));

        long countAfter = bookRepository.count();

        assertThat(countAfter).isEqualTo(countBefore + 1);

    }

    @Test
    @Order(2)
    void testJpaTestSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
