package com.reddit.reddit.Controller;

import com.reddit.reddit.Domain.User;
import com.reddit.reddit.Service.PostService;
import com.reddit.reddit.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostService postService;
    private UserService userService;
    private Integer pageNumberForVote;
    private String orderForIndex;

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
        pageNumberForVote = 0;
        orderForIndex = "trending";
        return "redirect:/"+username+"/"+orderForIndex+"?page="+pageNumberForVote;
    }

    @GetMapping("/{username}/{order}")
    public String getPosts(Model model, @PathVariable String username, @PathVariable String order,@RequestParam (defaultValue = "0") int page){
        if(userService.findByName(username) == null){
            return "redirect:/login";
        }
        pageNumberForVote = page;
        orderForIndex = order;
        if(order.equals("fresh")){
            model.addAttribute("orderForSite", orderForIndex);
            model.addAttribute("pageForVote", pageNumberForVote);
            model.addAttribute("pageNumber", postService.getPageNumberForAll());
            model.addAttribute("user", userService.findByName(username));
            model.addAttribute("posts", postService.findAllNewest(PageRequest.of(page, 10)));

            return "index";
        }

        model.addAttribute("orderForSite", orderForIndex);
        model.addAttribute("pageForVote", pageNumberForVote);
        model.addAttribute("pageNumber", postService.getPageNumberForAll());
        model.addAttribute("user", userService.findByName(username));
        model.addAttribute("posts", postService.findAllPaged(PageRequest.of(page, 10)));

        return "index";

    }

    @GetMapping("/change/{id}/{order}")
    public String changeLike(@PathVariable Long id, @RequestParam Integer number, @RequestParam String username, @RequestParam Integer page, @PathVariable String order){
        if(order.equals("fresh") || order.equals("trending")){
            postService.change(id, number);
            return "redirect:/"+username+"/"+orderForIndex+"?page="+page;
        }

        return "redirect:/"+username+"/"+orderForIndex+"?page="+page;
    }

    @GetMapping("/{username}/add-post")
    public String getAddPostForm(@PathVariable String username, Model model){
        model.addAttribute("user", userService.findByName(username));
        return "add-post";
    }

    @PostMapping("/{username}/add-post")
    public String addPost(@PathVariable String username, @RequestParam String title, @RequestParam String URL){
        postService.addPost(title, URL, userService.findByName(username));
        return "redirect:/"+username+"/"+orderForIndex+"?page=0";
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
        model.addAttribute("pageNumber", userService.getPageNumberByUser(username));
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

    @GetMapping("/{username}/delete")
    public String delete(@RequestParam Long postId, @PathVariable String username){
        postService.delete(postId);
        return "redirect:/"+username+"/own-posts?page=0";
    }
}
