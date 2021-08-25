package ua.com.alevel.data;

public class UserDto {

    private String name;

    public UserDto(User user) {
        this.name = user.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
