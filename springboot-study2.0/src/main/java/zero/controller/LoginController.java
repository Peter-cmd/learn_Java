package zero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zero.model.Duck;
import zero.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(User user, HttpServletRequest request){
        System.out.printf("username=%s password=%s\n" , user.getUsername(), user.getPassword());
        if ("李斯".equals(user.getUsername()) && "123".equals(user.getPassword())){
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            return "redirect:/user/login5";
        }else if ("a".equals(user.getUsername())) {
            throw new RuntimeException("用户为a,出错了!");
        }else{
            return "/login.html";
        }
    }

    @RequestMapping("/login2")
    public String login2(){
        return "/login.html";
    }


    @RequestMapping(value = "/{id}/login3", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Duck login3(@PathVariable("id") Integer id){
        System.out.printf("id=%d\n", id);
        return new Duck("LadyGaga", 5);
    }

    @RequestMapping(value = "/login4", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Duck login4(@RequestBody User user){
        System.out.println("username = " + user.getUsername() + " password = " + user.getPassword());
        return new Duck("LadyGaga", 5);
    }


    @RequestMapping("/login5")
    public String login5(Model model){
        model.addAttribute("duck", new Duck("LadyGaga", 5));
        return "/index";
    }

}
