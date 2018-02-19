package ua.lviv.likebooks.service;

import ua.lviv.likebooks.entity.User;

public interface MailService {
    void send(User user);
}
