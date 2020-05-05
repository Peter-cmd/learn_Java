package zero.controller;

import org.springframework.ui.Model;
import zero.model.Article;
import zero.service.ArticleService;
import zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zero.model.User;

@Controller
@RequestMapping("/user2")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/insert")
    @ResponseBody
    public User insert(User user){
        int num = userService.insert(user);
        return user;
    }

    @RequestMapping("/query")
    @ResponseBody
    public User query(Long id){
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping("/query/article")
    public String queryArticleById(Long id, Model model){
        Article article = articleService.queryArticleById(id);
        model.addAttribute("article", article);
        return "/info";
    }
}
