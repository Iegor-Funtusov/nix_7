package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.UserDto;
import ua.com.alevel.entity.User;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.service.SecurityService;
import ua.com.alevel.service.UserService;
import ua.com.alevel.service.impl.SecurityServiceImpl;
import ua.com.alevel.service.impl.UserServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class UserFacadeImpl implements UserFacade {

    private final UserService userService = new UserServiceImpl();
    private final SecurityService securityService = new SecurityServiceImpl();

    @Override
    public void register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.create(user);
    }

    @Override
    public void updateByToken(UserDto dto, String token) {
        String userId = securityService.findUserIdByToken(token);
        User user = userService.findById(userId);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        userService.update(user);
    }

    @Override
    public void deleteByToken(String token) {
        String userId = securityService.findUserIdByToken(token);
        userService.delete(userId);
    }

    @Override
    public UserDto findByToken(String token) {
        String userId = securityService.findUserIdByToken(token);
        User user = userService.findById(userId);
        return new UserDto(user);
    }

    @Override
    public List<UserDto> findAllByToken(String token) {
        List<User> users = userService.findAll();
        return users
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }
}
