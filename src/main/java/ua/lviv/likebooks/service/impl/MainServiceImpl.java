package ua.lviv.likebooks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ua.lviv.likebooks.entity.User;
import ua.lviv.likebooks.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MainServiceImpl implements MailService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(User user) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom("sergiyageev@gmail.com");
            helper.setTo(user.getEmail());
            helper.setText("Hello, "+user.getUsername()+" !",true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }


}
