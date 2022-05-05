package betsafe;

import betsafe.model.User;
import betsafe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public @ResponseBody User registerUser(@RequestBody User user) {
        System.out.println("asd");
        userService.signUpUser(user);
        return user;
    }

}

