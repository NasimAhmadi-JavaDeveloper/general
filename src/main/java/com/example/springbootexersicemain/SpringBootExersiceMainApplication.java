package com.example.springbootexersicemain;

import com.example.springbootexersicemain.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class SpringBootExersiceMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootExersiceMainApplication.class, args);
    }

    @Bean
    CommandLineRunner postQueries(PostRepository postRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                List<Post> p1 = postRepository.findVipPostsByUserRole("admin");
//                List<Post> p2 = postRepository.findPostsByUsersWithPostCountGreaterThan(6);
//
//                Timestamp date = Timestamp.valueOf("2024-06-27 00:00:00");
//                List<Post> p3 = postRepository.findPostsByUsersRegisteredAfter(date);
//                List<Object[]> p4 = postRepository.findPostSummariesWithUserDetails();


            }
        };
    }

}
