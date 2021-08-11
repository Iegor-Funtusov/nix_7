package ua.com.alevel.facade;

import ua.com.alevel.dto.UserDto;

import java.util.List;

public interface UserFacade {

    void register(String email, String password);
    void updateByToken(UserDto user, String token);
    void deleteByToken(String token);
    UserDto findByToken(String token);
    List<UserDto> findAllByToken(String token);
}
