package ru.itmentor.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.repositories.UserRepository;
import java.util.List;


@Service
@Transactional()
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
        return  user;
    }

    public List<User> listAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }
}