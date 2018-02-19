package ua.lviv.likebooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.likebooks.entity.Authority;
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
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Principal principal, Model model) {
        model.addAttribute("principal", principal);
        return "adminpage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("password") String password,
                       @RequestParam("email") String email) {
        userService.save(new User(email, username, password));
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        userService.delete(id);
        return "/adminpage";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/index";
    }

    @GetMapping("/showallusers")
    public String showAllUsers(Model model) {
        List<User> user = userService.findAll();
        model.addAttribute("UserX", userService.findAll());
        return "userEditPage";
    }

    @PostMapping("/updateUser")
    public String updateBook(
            @RequestParam int id,
            @RequestParam String username,
            @RequestParam String email
    ) {

        User userOne = userService.findOne(id);
        userOne.setUsername(username);
        userOne.setEmail(email);
        userService.save(userOne);

        return "userEditPage";
    }

    @RequestMapping("/user")
    public String editUser (Principal principal,
                            Model uiModel){
        User user = userService.findByUserName(principal.getName());
        uiModel.addAttribute("user", user);
        return "UserEdit";
    }
}
