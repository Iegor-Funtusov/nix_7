package ua.com.alevel.domain;

public class ImmutableUser {

    private final Integer age;
    private final String name;

    public ImmutableUser(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
