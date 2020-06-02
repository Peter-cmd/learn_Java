package zero.controller;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zero.model.Article;
import zero.model.Category;
import zero.model.Comment;
import zero.model.User;
import zero.service.ArticleService;
import zero.service.CategoryService;
import zero.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model){
        List<Article> articles = articleService.queryArticles();
        model.addAttribute("articleList", articles);
        return "index";
    }

    @RequestMapping("/a/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        Article article = articleService.queryArticle(id);
        List<Comment> comments = commentService.queryComments(id);
        article.setCommentList(comments);
        model.addAttribute("article", article);
        return "info";
    }

    @RequestMapping("/writer")
    public String writer(HttpSession session, Long activeCid, Model model){
        User user = (User) session.getAttribute("user");
        List<Article> articles = articleService.queryArticlesByUserId(user.getId());
        model.addAttribute("articleList", articles);
        List<Category> categories = categoryService.queryCategoriesByUserId(user.getId());
        model.addAttribute("categoryList", categories);
        model.addAttribute("activeCid",
                activeCid == null ? categories.get(0).getId() : activeCid);
        return "writer";
    }

    /**
     * 跳转到新增/修改文章页面(editor页面)
     * @param type 若 type 为 1,新增文章; 若 type 为 2,修改文章
     * @param id 新增时,代表 categoryId, 修改时,代表 articleId
     * @param model editor页面需要 type, category 和 article, 当新增时需要 activeCid, 修改时需要 article.id
     * @return
     */
    @RequestMapping("/writer/forward/{type}/{id}/editor")
    public String editor(@PathVariable("type") Integer type,
                         @PathVariable("id") Long id, Model model){
        Category category;
        if (type == 1){
            category = categoryService.queryCategoryById(id);
            model.addAttribute("activeCid", id);
        }else{
            Article article = articleService.queryArticle(id);
            model.addAttribute("article", article);
            category = categoryService.queryCategoryById(new Long(article.getCategoryId()));
        }
        model.addAttribute("type", type);
        model.addAttribute("category", category);
        return "editor";
    }

    @RequestMapping(value = "/writer/article/{type}/{id}", method = RequestMethod.POST)
    public String publish(@PathVariable("type") Integer type,
                          @PathVariable("id") Long id,
                          HttpSession session,
                          Article article,
                          Model model){
        article.setUpdatedAt(new Date());
        if (type == 1){
            article.setCategoryId(id.intValue());
            User user = (User)session.getAttribute("user");
            article.setUserId(user.getId());
            article.setCoverImage("https://picsum.photos/id/1/400/300");
            article.setCreatedAt(new Date());
            article.setStatus((byte)0);
            article.setViewCount(0L);
            article.setCommentCount(0);
            int num = articleService.insert(article);
            id = article.getId();

        }else {
            article.setId(id);
            int num = articleService.updateByCondition(article);
        }
        return String.format("redirect:/writer/forward/2/%s/editor", id);
    }

}
