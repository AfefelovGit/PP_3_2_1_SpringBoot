package ru.kata.task3_1_2.dao;

import ru.kata.task3_1_2.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
}
