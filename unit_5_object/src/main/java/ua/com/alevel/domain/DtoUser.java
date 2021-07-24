package ua.com.alevel.domain;

public class DtoUser {

    private int age;

    public DtoUser(final User user) {
        this.age = user.getAge();
    }
}
