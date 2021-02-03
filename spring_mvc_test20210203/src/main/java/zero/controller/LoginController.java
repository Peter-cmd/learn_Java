package zero.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zero.model.User;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public User login(User user) {
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("李华");
        System.out.println("内容是: " + user1.getId() + " " + user1.getUsername());
        return user;
    }

    @RequestMapping("/1")
    @ResponseBody
    public ResponseEntity t0() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "战三");
        map.put(2, "李斯");
        map.put(3, "李留");
        return ResponseEntity.status(600).body(map);
    }

}
