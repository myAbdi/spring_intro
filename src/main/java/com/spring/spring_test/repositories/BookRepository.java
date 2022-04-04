package com.spring.spring_test.repositories;

import com.spring.spring_test.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
