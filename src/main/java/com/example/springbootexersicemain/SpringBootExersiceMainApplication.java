package com.example.springbootexersicemain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootExersiceMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootExersiceMainApplication.class, args);
    }

//    @Bean
//    CommandLineRunner lineRunner(UserRepository userRepository) {
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//                User user = userRepository.findUser(1L);
//            }
//        };
//    }

//    @Bean
//    CommandLineRunner lineRunner(AuthorRepository authorRepository) {
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//                Author author = authorRepository.findAuthorById(1L);
//            }
//        };
//    }

//    @Bean
//    CommandLineRunner lineRunner(AuthorRepository authorRepository) {
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//                List<Author> author = authorRepository.fetchAuthorsBooksByPriceInnerJoin(500);
//            }
//        };
//    }

//    @Bean
//    CommandLineRunner lineRunner(AuthorRepository authorRepository) {
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//                List<Author> author = authorRepository.fetchAuthorsBooksByPriceJoinFetch(500);
//            }
//        };
//    }

//    @Bean
//    CommandLineRunner lineRunner(BookRepository bookRepository) {
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//                List<Book> author = bookRepository.fetchBooksAuthorsInnerJoinBad();
//            }
//        };
//    }

//    @Bean
//    CommandLineRunner lineRunner(BookRepository bookRepository) {
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//                List<Book> author = bookRepository.fetchBooksAuthorsInnerJoinGood();
//            }
//        };
//    }

//    @Bean
//    CommandLineRunner lineRunner(BookRepository bookRepository) {
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... args) throws Exception {
//                List<Book> author = bookRepository.fetchBooksAuthorsJoinFetch();
//            }
//        };
//    }
}
