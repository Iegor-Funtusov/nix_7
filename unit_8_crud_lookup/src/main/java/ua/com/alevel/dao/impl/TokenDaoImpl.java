package ua.com.alevel.dao.impl;

import ua.com.alevel.bd.ListBD;
import ua.com.alevel.dao.TokenDao;
import ua.com.alevel.entity.Token;

public class TokenDaoImpl implements TokenDao {

    @Override
    public void create(Token token) {
        ListBD.getInstance().createToken(token);
    }

    @Override
    public boolean existByToken(String token) {
        return ListBD.getInstance().existByToken(token);
    }

    @Override
    public Token findByToken(String token) {
        return ListBD.getInstance().findByToken(token);
    }
}
