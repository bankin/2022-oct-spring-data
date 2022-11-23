package bg.softuni.workshop.controllers;

import bg.softuni.workshop.models.users.User;
import bg.softuni.workshop.models.users.LoginDTO;
import bg.softuni.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/users/login")
    public String doLogin(LoginDTO loginDTO) {
        Optional<User> user = userService.login(loginDTO);

        if (user.isPresent()) {
            return "redirect:/home";
        }

        return "user/login";
    }
}
