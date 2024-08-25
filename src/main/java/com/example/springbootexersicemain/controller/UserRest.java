package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.exception.UniqueConstraintException;
import com.example.springbootexersicemain.model.dto.UserDto;
import com.example.springbootexersicemain.service.facade.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserRest {

    private final UserService service;

    public UserRest(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/select_all_user")
    public ResponseEntity<List<UserDto>> selectAllUser() {
        return ResponseEntity.ok(service.select());
    }

    @PostMapping(path = "/save_user")
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto.InsertUserDto dto) throws UniqueConstraintException {
        return ResponseEntity.ok(service.save(dto));
    }

    @PostMapping(path = "/update_user")
    public ResponseEntity<UserDto> update(@RequestBody @Valid UserDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(path = "/select_number_of_repeat")
    public ResponseEntity<List<Map<Integer, Integer>>> selectNumberOfRepeat() {
        return ResponseEntity.ok(service.selectByNumberOfRepeat());
    }

    @GetMapping(path = "/select_flat_map")
    public ResponseEntity<List<String>> selectFlatMap() {
        return ResponseEntity.ok(service.checkFlatMap());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/find-user-by-id")
    public ResponseEntity<UserDto> getUserByIdUsingQueryParam(@RequestParam Long id) {
        return ResponseEntity.ok(service.getUserByIdUsingQueryParam(id));
    }
}
