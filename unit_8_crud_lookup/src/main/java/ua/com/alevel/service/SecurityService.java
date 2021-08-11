package ua.com.alevel.service;

public interface SecurityService {

    String login(String email, String password);
    String findUserIdByToken(String token);
}
