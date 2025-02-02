package ru.kata.task3_1_2.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;

import java.io.Serializable;

import static java.lang.String.format;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "FirstName cannot be empty.")
    @Size(min = 2, max = 30, message = "FirstName must be from 2 to 30 characters.")
    @Column(nullable = false, length = 30)
    private String firstName;

    @NotEmpty(message = "LastName cannot be empty.")
    @Size(min = 2, max = 30, message = "LastName must be from 2 to 30 characters.")
    @Column(nullable = false, length = 30)
    private String lastName;

    @NotEmpty(message = "Email cannot be empty.")
    @Email(message = "Value does not match Email.")
    @Column(nullable = false, length = 50)
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return format("{id:%d -  %s %s %s}", id, firstName, lastName, email);
    }
}
