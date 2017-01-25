package blog.controllers;

import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by United121 on 1/24/2017.
 */
@Controller
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping("/posts/view/{id}")
    public String showPost(@PathVariable("id") Long id, Model model){
        Post post = postService.findById(id);
        if(post == null){
            notificationService.addErrorMsg("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }
}
