package ua.com.alevel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.entity.User;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String fullName;
    private String email;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.fullName = this.firstName + " " + this.lastName;
    }
}
