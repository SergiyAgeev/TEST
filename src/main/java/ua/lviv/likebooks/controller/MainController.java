package ua.lviv.likebooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.likebooks.dao.LikeDAO;
import ua.lviv.likebooks.entity.Post;
import ua.lviv.likebooks.entity.User;
import ua.lviv.likebooks.service.LikeService;
import ua.lviv.likebooks.service.MailService;
import ua.lviv.likebooks.service.PostService;
import ua.lviv.likebooks.service.UserService;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class MainController {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private LikeService likeService;


    @RequestMapping("/")
    public String home(Model model) {
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);
//        model.addAttribute("query", likeService.findUserByPost());

        List<Post> latest3Posts = latest5Posts.stream()
                .limit(3).collect(toList());
        model.addAttribute("latest3posts", latest3Posts);



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
    public String save(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("email") String email,
                       @RequestParam("avatar") MultipartFile avatar) {
        String path = System.getProperty("user.home") + File.separator + "Multipart\\";
        try {
            avatar.transferTo(new File(path + avatar.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setAvatar("\\userAvatar\\" + avatar.getOriginalFilename());
        userService.save(user);
        mailService.send(user);


        return "redirect:/";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        userService.delete(id);
        return "/adminpage";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
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
    public String editUser(Principal principal,
                           Model uiModel) {
        User user = userService.findByUserName(principal.getName());
        uiModel.addAttribute("user", user);
        return "UserEdit";
    }

    @GetMapping("/Register")
    public String register() {
        return "RegisterPage";
    }


    @GetMapping("/getinfo")
    public String getinfo() {
        return "InfoPage";
    }


}
