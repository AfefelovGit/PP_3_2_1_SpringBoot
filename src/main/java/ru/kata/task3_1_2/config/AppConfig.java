package ru.kata.task3_1_2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// классов конфигурации может быть несколько

@Configuration
@ComponentScan(value = "ru.kata.task3_1_2")
public class AppConfig {

    /*
     Здесь должна быть конфигурация, которая будет выполнена в самом начале.
     В ней должны быть заданы Бины, которые пройдут предварительную инициализацию

     */
}
