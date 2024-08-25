//package com.example.springbootexersicemain.service.impl;
//
//import com.example.springbootexersicemain.model.dto.DocumentDto;
//import com.example.springbootexersicemain.service.facade.DocumentService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.validation.ValidationException;
//import java.util.List;
//
//@Slf4j
//@SpringBootTest
//class DocumentServiceImplTest {
//
//    private DocumentDto dto;
//
//    @Autowired
//    private DocumentService service;
//
//    @BeforeEach
//    void setUp() {
//        dto = new DocumentDto();
//        dto.setName("hamide");
//        dto.setChecksum(12L);
//        dto.setLength(15L);
//    }
//
//    @AfterEach
//    void tearDown() {
//        dto = null;
//    }
//
//    @Test
//    void select() {
//        List<DocumentDto> result = service.select();
//        Assertions.assertNotNull(result);
//    }
//
//    @Test
//    void saveIdNotNull() {
//        DocumentDto saved = service.save(dto);
//        Assertions.assertNotNull(saved.getId());
//    }
//
//    @Test
//    void saveNotValidInput() {
//        DocumentDto dto1 = new DocumentDto();
//        dto1.setName("zohre");
//        Assertions.assertThrows(ValidationException.class, () -> service.save(dto1));
//    }
//
//}