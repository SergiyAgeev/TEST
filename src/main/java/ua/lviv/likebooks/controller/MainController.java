package ua.lviv.likebooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.likebooks.entity.User;
import ua.lviv.likebooks.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index()
    {
        return "index";
    }


    @GetMapping("/admin")
    public String admin(Principal principal, Model model) {
        model.addAttribute("principal", principal);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("password") String password,
                       @RequestParam("email") String email, @RequestParam("number") String number){
        userService.save(new User(email, number, username, password));
        return "redirect:/";
    }
}
