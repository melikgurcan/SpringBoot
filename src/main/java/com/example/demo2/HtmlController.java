package com.example.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/html")
public class HtmlController {
    private final UserService userService;

    public HtmlController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "addUser";
    }

    @PostMapping("/users")
    public String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String address) {
        userService.addUser(name, email, address);
        return "redirect:/html/users";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("userList",userService.getAllUsers());
        return "allUsers";
    }

}
