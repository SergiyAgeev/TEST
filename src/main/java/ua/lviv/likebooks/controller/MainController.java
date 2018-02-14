package ua.lviv.likebooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String index(){
        return "index";
    }

//        List<String> stringList = new ArrayList<>();
//        stringList.add("1");
//        stringList.add("2");
//        stringList.add("3");
//        stringList.add("4");
//        model.addAttribute("list", stringList);





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
                       @RequestParam("email") String email){
        userService.save(new User(email, username, password));
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        userService.delete(id);
        return "redirect:/adminpage";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/index";
    }

    @GetMapping("/showallusers")
    public String showAllUsers(Model model){
        List<User> user = userService.findAll();
        model.addAttribute("UserX", userService.findAll());
        return "userEditPage";
    }



}
