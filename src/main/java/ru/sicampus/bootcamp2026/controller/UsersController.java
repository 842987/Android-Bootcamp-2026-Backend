package ru.sicampus.bootcamp2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sicampus.bootcamp2026.dto.UsersDTO;
import ru.sicampus.bootcamp2026.service.UsersService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUser(@RequestParam long id) {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<UsersDTO> createUser(@RequestBody UsersDTO usersDTO) {
        return ResponseEntity.ok(usersService.createUser(usersDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDTO> updateUser(@RequestParam long id, @RequestBody UsersDTO usersDTO) {
        return ResponseEntity.ok(usersService.updateUser(id, usersDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@RequestParam long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}