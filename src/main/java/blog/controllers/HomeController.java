package blog.controllers;

import blog.models.Post;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by United121 on 1/23/2017.
 */
@Controller
public class HomeController {

    /*
     It automatically injects the correct implementation for your services at the places where they are needed.
      Developers just type “@Autowired“. Spring scans the project and finds all classes that implement the service interface.
      If only one such class is found, it is instantiated and its instance is auto-wired (injected) in the field
      or method parameter where it is requested.
     */
    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String index(Model model) {

        List<Post> posts = postService.findLatest5();
        model.addAttribute("latest5posts" , posts);

       // List<Post> latest3Post = postService.findAll().stream().limit(3).collect(Collectors.toList());
        List<Post> latest3Post = posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts",latest3Post);

        // located in the file src/main/resources/templates/index.html.
        return "index";
    }
}
