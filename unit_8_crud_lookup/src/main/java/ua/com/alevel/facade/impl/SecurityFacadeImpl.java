package ua.com.alevel.facade.impl;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.facade.SecurityFacade;
import ua.com.alevel.service.SecurityService;

public class SecurityFacadeImpl implements SecurityFacade {

    private final SecurityService securityService = ObjectFactory.getInstance().getImplClass(SecurityService.class);

    @Override
    public String login(String email, String password) {
        return securityService.login(email, password);
    }
}
