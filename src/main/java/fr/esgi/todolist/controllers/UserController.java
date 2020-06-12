package fr.esgi.todolist.controllers;

import fr.esgi.todolist.models.User;
import fr.esgi.todolist.services.TodoListService;
import fr.esgi.todolist.services.UserService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private TodoListService todoListService;

    @GetMapping(value="/users")
    public List<User> getUsers() { return userService.findAll(); }


}
