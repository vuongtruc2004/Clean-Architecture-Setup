package org.yourapp.user.model;

public class User {
    private Long id;
    private String fullName;
    private Age age;
    private Email email;

    private User(String fullName, Age age, Email email) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }

    public static User create(String fullName, Age age, Email email) {
        return new User(fullName, age, email);
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Age getAge() {
        return age;
    }

    public Email getEmail() {
        return email;
    }
}
