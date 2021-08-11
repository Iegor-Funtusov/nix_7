package ua.com.alevel.dao;

import ua.com.alevel.entity.Token;

public interface TokenDao {

    void create(Token token);
    boolean existByToken(String token);
    Token findByToken(String token);
}
