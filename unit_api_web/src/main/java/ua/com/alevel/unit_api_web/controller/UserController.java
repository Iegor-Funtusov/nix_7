package ua.com.alevel.unit_api_web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.unit_api_web.container.DataContainer;
import ua.com.alevel.unit_api_web.domain.User;
import ua.com.alevel.unit_api_web.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>>create(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>>delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<User>>findById(@PathVariable String id) {
        return ResponseEntity.ok(new DataContainer<>(userService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<List<User>>>findAll() {
        return ResponseEntity.ok(new DataContainer<>(userService.findAll()));
    }
}
