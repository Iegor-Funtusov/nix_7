package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
