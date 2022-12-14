package br.com.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping(value = "/{id}")
    public User user(@PathVariable("id") Long id) {
        System.out.println(id);
        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }

    @PostMapping(value = "/")
    public User user(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @GetMapping(value = "/list")
    public List<User> list() {
        return users;
    }

}
