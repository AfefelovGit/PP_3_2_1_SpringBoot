package ru.kata.task3_1_2.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.task3_1_2.dao.UserDao;
import ru.kata.task3_1_2.dao.UserRepository;
import ru.kata.task3_1_2.model.User;

@Component
public class DataLoader {

    private final UserRepository userRepository;
    private final UserDao userDao;

    @Autowired
    public DataLoader(UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    @PostConstruct
    private void loadData() {
        userRepository.deleteAll();
        userRepository.save(new User("Петр", "Иванов", "mail1@mail.ru"));
        userRepository.save(new User("Bill", "Natar", "mail2@mail.ru"));
        userRepository.save(new User("Руслан", "Валеев", "mail3@mail.ru"));

        // проверим запись
        System.out.println(userDao.findAll());
    }
}
