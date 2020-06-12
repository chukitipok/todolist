package fr.esgi.todolist.services;

import fr.esgi.todolist.models.User;
import fr.esgi.todolist.services.interfaces.UserServiceInterface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService implements UserServiceInterface {

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
