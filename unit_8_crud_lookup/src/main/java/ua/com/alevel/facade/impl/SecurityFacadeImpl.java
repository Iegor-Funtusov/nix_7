package ua.com.alevel.facade.impl;

import ua.com.alevel.facade.SecurityFacade;
import ua.com.alevel.service.SecurityService;
import ua.com.alevel.service.impl.SecurityServiceImpl;

public class SecurityFacadeImpl implements SecurityFacade {

    private final SecurityService securityService = new SecurityServiceImpl();

    @Override
    public String login(String email, String password) {
        return securityService.login(email, password);
    }
}
