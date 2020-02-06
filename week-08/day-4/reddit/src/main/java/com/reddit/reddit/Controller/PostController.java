package com.reddit.reddit.Controller;

import com.reddit.reddit.Domain.User;
import com.reddit.reddit.Service.PostService;
import com.reddit.reddit.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    PostService postService;
    UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String homepageLoggedIn(@RequestParam String username, @RequestParam String password){
        User user = userService.findUserByNameAndPW(username, password);
        if(user == null) {
            return "redirect:/login";
        }
        return "redirect:/"+username;
    }

    @GetMapping("/{username}")
    public String getPosts(Model model, @PathVariable String username){
        if(userService.findByName(username) == null){
            return "redirect:/login";
        }

        model.addAttribute("user", userService.findByName(username));
        model.addAttribute("posts", postService.findTopTen());

        return "index";
    }

    @GetMapping("/change/{id}")
    public String changeLike(@PathVariable Long id, @RequestParam Integer number, @RequestParam String username){
        postService.change(id, number);
        return "redirect:/"+username;
    }

    @GetMapping("/{username}/add-post")
    public String getAddPostForm(@PathVariable String username, Model model){
        model.addAttribute("user", userService.findByName(username));
        return "add-post";
    }

    @PostMapping("/{username}/add-post")
    public String addPost(@PathVariable String username, @RequestParam String title, @RequestParam String URL){
        postService.addPost(title, URL, userService.findByName(username));
        return "redirect:/"+username;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password){
            return userService.registerUser(username, password);

    }

    @GetMapping("/{username}/own-posts")
    public String showOwnPosts(@PathVariable String username, Model model){
        model.addAttribute("user", userService.findByName(username));
        model.addAttribute("posts", postService.getAllByUser(userService.findByName(username)));
        return "own-posts";
    }

    /*@GetMapping("/{username}/edit-post")
     public String editPost(Model model, @RequestParam String username, @RequestParam String){
        model.addAttribute("post", postService.)
    }*/
}
