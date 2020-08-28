package com.udacity.jwdnd.c1.review.Controller;

import com.udacity.jwdnd.c1.review.Model.User;
import com.udacity.jwdnd.c1.review.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class SignupController {
    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String signupView() {
        return "signup";
    }

    @PostMapping
    public String signupUser(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {
        String signupError = null;

        if (this.userService.isUserPresent(user.getUsername())) {
            signupError = "User already exists, try logging in.";
            return "signup";
        }

        if (signupError == null) {
            int rowsAdded = this.userService.addUser(user);
            if (rowsAdded < 0) {
                signupError = "There was an error signing you up. Please try later.";
                model.addAttribute("signupError", signupError);
                return "signup";
            } else {
                model.addAttribute("signupSuccess", true);
                return "redirect:/login";
            }
        }

        return "signup";
    }
}
