package ru.kata.task3_1_2.service;

import ru.kata.task3_1_2.model.User;

public interface UserService {

    void addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    Iterable<User> getAllUsers();
}
