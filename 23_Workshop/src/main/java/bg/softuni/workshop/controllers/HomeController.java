package bg.softuni.workshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {

//        model.addAttribute("username", "Pesho");

        return "index";
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }


}
