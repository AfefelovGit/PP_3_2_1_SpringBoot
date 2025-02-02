package ru.kata.task3_1_2.dao;

import org.springframework.data.repository.CrudRepository;
import ru.kata.task3_1_2.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
