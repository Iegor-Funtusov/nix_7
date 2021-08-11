package ua.com.alevel.service.impl;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.TokenDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.Token;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.SecurityService;
import ua.com.alevel.util.SecurityUtil;

import java.util.UUID;

public class SecurityServiceImpl implements SecurityService {

    private final UserDao userDao = ObjectFactory.getInstance().getImplClass(UserDao.class);
    private final TokenDao tokenDao = ObjectFactory.getInstance().getImplClass(TokenDao.class);

    @Override
    public String login(String email, String password) {
        Token token = new Token();
        String hashPassword = SecurityUtil.hashPassword(password);
        User user = userDao.findUserIdByEmailAndPassword(email, hashPassword);
        token.setUserId(user.getId());
        token.setToken(generateToken());
        tokenDao.create(token);
        return token.getToken();
    }

    @Override
    public String findUserIdByToken(String token) {
        Token tokenEntity = tokenDao.findByToken(token);
        return tokenEntity.getUserId();
    }

    private String generateToken() {
        String token = UUID.randomUUID().toString();
        if (tokenDao.existByToken(token)) {
            return generateToken();
        }
        return token;
    }
}
