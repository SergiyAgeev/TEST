package ua.lviv.likebooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.likebooks.entity.Comments;
import ua.lviv.likebooks.entity.Like;
import ua.lviv.likebooks.entity.Post;
import ua.lviv.likebooks.entity.User;
import ua.lviv.likebooks.service.LikeService;
import ua.lviv.likebooks.service.PostService;
import ua.lviv.likebooks.service.UserService;

import java.util.Date;

@Controller
public class LikeController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private LikeService likeService;

    @PostMapping("/likeIt")
    public String makelike(@RequestParam("postId") int postId, @RequestParam("userId") int userId,
                         @RequestParam("like") String likeIt) {

        Like like = new Like();
        like.setPostId(postService.findById(postId));
        like.setUserId(userService.findOne(userId));
        like.setLikes(likeIt);
        likeService.save(like);
        return "PostPages";
    }


}
