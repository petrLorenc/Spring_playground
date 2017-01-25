package blog.controllers;

import blog.forms.LoginForm;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by United121 on 1/25/2017.
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notificationService.addErrorMsg("Please fill the form correctly!");
            return "users/login";
        }

        if (!userService.authenticate(loginForm.getUsername(), loginForm.getPassword())) {
            notificationService.addErrorMsg("Invalid login!");
            return "users/login";
        }

        notificationService.addInfoMsg("Login successful");
        return "redirect:/";
    }
}
