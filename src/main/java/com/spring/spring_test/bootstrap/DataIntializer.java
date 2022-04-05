package com.spring.spring_test.bootstrap;

import com.spring.spring_test.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.spring.spring_test.repositories.BookRepository;

@Component
@Profile({"local", "default"})
public class DataIntializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataIntializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        Book bookDDD = new Book("123", "Domain driven design", "O'Reilly", null);
        System.out.println("id: " + bookDDD.getId());

        Book savedDDD = bookRepository.save(bookDDD);
        System.out.println("id: "+ savedDDD.getId());

        Book bookSIA = new Book("125", "Spring in action", "House publisher", null);
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());
        });
    }
}
