package br.edu.unichristus.controller;

import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @GetMapping("/all")
    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return service.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}
