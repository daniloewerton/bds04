package com.devsuperior.bds04.resources;

import com.devsuperior.bds04.dto.UserDTO;
import com.devsuperior.bds04.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody final UserDTO dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
