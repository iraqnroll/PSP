package psp.laboratorinis.lab13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import psp.laboratorinis.lab13.helpers.Result;
import psp.laboratorinis.lab13.model.User;
import psp.laboratorinis.lab13.service.UserService;

import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    UserService service;

    public UserController(){
        super();
    }

    public UserController(UserService service){
        super();
        this.service = service;
    }

    @GetMapping("/create-user")
    public String createUserView(Model model){
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/create-user")
    public RedirectView createUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        final RedirectView redirectView = new RedirectView("/create-user", true);
        Result result = service.save(user);

        if(result.getNewUser() == null){
            redirectAttributes.addFlashAttribute("result", false);
            redirectAttributes.addFlashAttribute("errors",
                    result.getError().stream().map(Enum::toString).collect(Collectors.joining(" , ")));
        }
        else{
            redirectAttributes.addFlashAttribute("result", true);
            redirectAttributes.addFlashAttribute("newUser", result.getNewUser().toString());
        }

        return redirectView;
    }
}
