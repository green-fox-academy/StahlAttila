package com.reddit.reddit.Controller;

import com.reddit.reddit.Domain.User;
import com.reddit.reddit.Service.PostService;
import com.reddit.reddit.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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
        return "redirect:/"+username+"?page=0";
    }

    @GetMapping("/{username}")
    public String getPosts(Model model, @PathVariable String username, @RequestParam int page){
        if(userService.findByName(username) == null){
            return "redirect:/login";
        }
        //***BUG*** on the home page the paging code only watches the logged in persons list size to creat the page numbers
        model.addAttribute("pageNumber", userService.getPageNumber(username));

        model.addAttribute("user", userService.findByName(username));
        model.addAttribute("posts", postService.findAllPaged(userService.findByName(username), PageRequest.of(page, 10)));

        return "index";
    }

    @GetMapping("/change/{id}")
    public String changeLike(@PathVariable Long id, @RequestParam Integer number, @RequestParam String username, @RequestParam int page){
        postService.change(id, number);
        return "redirect:/"+username+"?page="+page;
    }

    @GetMapping("/{username}/add-post")
    public String getAddPostForm(@PathVariable String username, Model model){
        model.addAttribute("user", userService.findByName(username));
        return "add-post";
    }

    @PostMapping("/{username}/add-post")
    public String addPost(@PathVariable String username, @RequestParam String title, @RequestParam String URL){
        postService.addPost(title, URL, userService.findByName(username));
        return "redirect:/"+username+"?page=0";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password){
        if(userService.findByName(username) == null ){
            userService.registerUser(username, password);
            return "redirect:/login";
        }

        return "redirect:/login";

    }

    @GetMapping("/{username}/own-posts")
    public String showOwnPosts(@PathVariable String username, Model model, @RequestParam int page){
        List<Integer> numberOfLinks = new ArrayList<>();
        for (int i = 0; i < (userService.findByName(username).getPosts().size()/5)+1 ; i++) {
            numberOfLinks.add(i);
        }
        model.addAttribute("pageNumber", numberOfLinks);
        model.addAttribute("user", userService.findByName(username));
        model.addAttribute("posts", postService.getAllByUser(userService.findByName(username), PageRequest.of(page, 5 )));
        return "own-posts";
    }

    @GetMapping("/{username}/edit-post")
     public String editPost(Model model, @PathVariable String username, @RequestParam Long postId){
        model.addAttribute("user", userService.findByName(username));
        model.addAttribute("post", postService.findById(postId));
        return "edit-post";
    }

    @PostMapping("/{username}/edit-post")
    public String editPostSend(@PathVariable String username, @RequestParam String title, @RequestParam String URL, @RequestParam Long postId){
        postService.updatePost(postId, title, URL, userService.findByName(username));
        return "redirect:/"+username+"/own-posts?page=0";
    }
}
