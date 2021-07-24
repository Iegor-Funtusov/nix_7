package ua.com.alevel.domain;

public class User {

    private int age;
    User user = new User();

    public void init(User user) {
        user.age = 45;
    }
    public User build(final User user) {
        return new User();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}
