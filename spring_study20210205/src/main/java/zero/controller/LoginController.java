package zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zero.model.User;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public User login(User user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setName(user.getName());
        return user1;
    }
}
