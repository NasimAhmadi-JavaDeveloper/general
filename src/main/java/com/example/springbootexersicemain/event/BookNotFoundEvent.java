package com.example.springbootexersicemain.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class BookNotFoundEvent extends ApplicationEvent {

    private final String bookTitle;

    public BookNotFoundEvent(Object source, String bookTitle) {
        super(source);
        this.bookTitle = bookTitle;
    }

}
