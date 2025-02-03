package ru.kata.task3_1_2.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.task3_1_2.model.User;
import ru.kata.task3_1_2.service.UserService;

@Controller
@RequestMapping("/user-service")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterablegit<User> users = userService.getAllUsers();

        model.addAttribute("users", users);
        return "/users/users";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "/users/view-user";
    }

    @GetMapping(value = "/new")
    public String createNewUser(@ModelAttribute("user") User user, Model model) {

        model.addAttribute("user", user);
        return "/users/new-user";
    }

    @PostMapping("/users")
    public String saveNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/users/new-user";
        }

        userService.addUser(user);
        return "redirect:/user-service/users";
    }

    @GetMapping(value = "/update")
    public String editOldUser(@RequestParam(name = "id", required = false) Long id, Model model) {
        User user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "/users/update-user";
    }

    @PutMapping("/users/{id}")
    public String updateOldUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "/users/update-user";
        }

        userService.updateUser(id, user);
        return "redirect:/user-service/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteOldUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return "redirect:/user-service/users";
    }
}
