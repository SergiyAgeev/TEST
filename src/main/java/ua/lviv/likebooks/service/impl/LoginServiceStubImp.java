package ua.lviv.likebooks.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.likebooks.service.LoginService;

import java.util.Objects;

@Service
public class LoginServiceStubImp implements LoginService {

    @Override
    public boolean authentice(String username, String password) {
        return Objects.equals(username, password);
    }
}
