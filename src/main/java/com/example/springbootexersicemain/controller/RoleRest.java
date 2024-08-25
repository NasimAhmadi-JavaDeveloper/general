package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.RoleDto;
import com.example.springbootexersicemain.service.facade.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleRest {

    private final RoleService service;

    public RoleRest(RoleService service) {
        this.service = service;
    }

    @GetMapping(path = "/select_all_role")
    public ResponseEntity<List<RoleDto>> selectAllRole() {
        return ResponseEntity.ok(service.select());
    }

    @PostMapping
    public ResponseEntity<RoleDto> save(@RequestBody @Valid RoleDto.InsertRoleDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/find-role-by-id")
    public ResponseEntity<RoleDto> getRoleByIdUsingQueryParam(@RequestParam Long id) {
        return ResponseEntity.ok(service.getRoleByIdUsingQueryParam(id));
    }

}
