package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.DocumentDto;
import com.example.springbootexersicemain.service.facade.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentRest {

    private final DocumentService service;

    public DocumentRest(DocumentService service) {
        this.service = service;
    }

    @GetMapping(path = "/select_all_document")
    public ResponseEntity<List<DocumentDto>> selectAllDocument() {
        return ResponseEntity.ok(service.select());
    }

    @PostMapping(path = "/save_document")
    public ResponseEntity<DocumentDto> save(@RequestBody @Valid DocumentDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PostMapping(path = "/update_document")
    public ResponseEntity<DocumentDto> update(@RequestBody @Valid DocumentDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
