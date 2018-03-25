package ua.lviv.likebooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.likebooks.entity.Comments;
import ua.lviv.likebooks.entity.Post;
import ua.lviv.likebooks.entity.User;
import ua.lviv.likebooks.service.CommentsService;
import ua.lviv.likebooks.service.PostService;
import ua.lviv.likebooks.service.UserService;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentsService commentsService;


    @RequestMapping("/post-{id}")
    public String view(@PathVariable("id") int id,
                       Model model1, Model model2) {
        Post post = postService.findById(id);



        model1.addAttribute("post", post);
        model2.addAttribute("commentQ", post.getComments());
        return "SelectPostPage";
    }

    @GetMapping("/showallcomments")
    public String allcomments(Model model/* @RequestParam("id") int id*/) {
        Post post = postService.findById(1);


        model.addAttribute("commentQ", post.getComments());
        return "SelectPostPage";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("postsX", posts);
        return "PostPages";
    }

    @PostMapping("/createonepost")
    public String create(@RequestParam("title") String title, @RequestParam("body") String body,
                         @RequestParam("author") String username) {

        Post post = new Post();
        post.setAuthor(userService.findByUserName(username));
        post.setBody(body);
        post.setTitle(title);
        post.setDate(new Date());
        postService.create(post);

        return "PostPages";
    }

    @PostMapping("/createpost")
    public String createpost(Principal principal,
                             Model uiModel) {
        User user = userService.findByUserName(principal.getName());
        uiModel.addAttribute("user", user);

        return "post";
    }

    @GetMapping("/showallpostsadmin")
    public String postsadmin(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("postsZ", posts);
        return "postsAdmin";
    }

    @GetMapping("/deletepost")
    public String deletepost(@RequestParam int id) {
        postService.deleteById(id);
        return "adminpage";
    }

    @PostMapping("/createcomment")
    public String save(@RequestParam("body") String body,
                       @RequestParam("post") int id,
                       @RequestParam("commentator") String username) {

        Comments comments = new Comments();
        comments.setCommentator(userService.findByUserName(username));
        comments.setPost(postService.findById(id));
        comments.setBody(body);
        comments.setDate(new Date());
        commentsService.save(comments);

        return "PostPages";
    }

    @PostMapping("/createcommentos")
    public String createcomment(Principal principal,
                                Model uiModel, @RequestParam ("id") int id) {

        Post post = postService.findById(id);
        User user = userService.findByUserName(principal.getName());
        uiModel.addAttribute("user", user);
        uiModel.addAttribute("post", post.getId());


        return "CreateCommentPage";
    }



}

