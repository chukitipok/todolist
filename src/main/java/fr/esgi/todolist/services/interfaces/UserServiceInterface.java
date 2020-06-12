package fr.esgi.todolist.services.interfaces;

import fr.esgi.todolist.models.User;

import java.util.List;

public interface UserServiceInterface {
    public List<User> findAll();
    public User findById(final int id);
    public User save(final User user);
}
