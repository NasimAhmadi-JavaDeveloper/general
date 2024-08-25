package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.PostDto;
import com.example.springbootexersicemain.service.facade.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostRest {

    private final PostService service;

    public PostRest(PostService service) {
        this.service = service;
    }

    @GetMapping(path = "/select_all_post")
    public ResponseEntity<List<PostDto.Transfer>> selectAllPost() {
        return ResponseEntity.ok(service.select());
    }

    @GetMapping(path = "/select_slug_isVip_true_stream")
    public ResponseEntity<List<String>> selectSlugIsVipTrueOne() {
        return ResponseEntity.ok(service.selectSlugIsVipTrueStream());
    }

    @GetMapping(path = "/select_slug_isVip_true_query")
    public ResponseEntity<List<String>> selectSlugIsVipTrueTwo() {
        return ResponseEntity.ok(service.selectSlugIsVipTrueQuery());
    }

    @GetMapping(path = "/select_any_match")
    public ResponseEntity<Object> selectAnyMatch() {
        return ResponseEntity.ok(service.checkAnyMatch());
    }

    @GetMapping(path = "/select_non_match")
    public ResponseEntity<Object> selectNonMatch() {
        return ResponseEntity.ok(service.checkNonMatch());
    }

    @GetMapping(path = "/select_find_first")
    public ResponseEntity<PostDto> selectFindFirst() {
        return ResponseEntity.ok(service.checkFindFirst());
    }

    @GetMapping(path = "/select_find_any")
    public ResponseEntity<PostDto> selectFindAny() {
        return ResponseEntity.ok(service.checkFindAny());
    }

    @PostMapping(path = "/select_optional")
    public ResponseEntity<List<String>> selectOptional(@RequestBody @Valid PostDto.UpdatePostDto dto) {
        return ResponseEntity.ok(service.checkOptional(dto));
    }

    @PostMapping(path = "/select_optional_nullable")
    public ResponseEntity<Object> selectOptionalNullable(@RequestBody @Valid PostDto.InsertPostDto dto) {
        return ResponseEntity.ok(service.optionalNullable(dto));
    }

}
