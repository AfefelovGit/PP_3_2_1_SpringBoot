package ru.kata.task3_1_2.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.kata.task3_1_2.dao.UserRepository;
import ru.kata.task3_1_2.model.User;

@Component
public class DataLoader {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void loadData() {
        userRepository.deleteAll();
        userRepository.save(new User("Петр", "Иванов", "mail1@mail.ru"));
        userRepository.save(new User("Bill", "Natar", "mail2@mail.ru"));
        userRepository.save(new User("Руслан", "Валеев", "mail3@mail.ru"));

    }
}
