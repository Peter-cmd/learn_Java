package org.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.study.mapper.ArticleMapper;
import org.study.mapper.UserMapper;
import org.study.model.Article;
import org.study.model.User;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ApplicationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByIdA() {
        Article article = articleMapper.selectById(2);
        System.out.println(article);
    }

    @Test
    public void selectByIdU() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void selectAllU() {
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);
    }

    @Test
    public void selectAllA() {
        List<Article> articles = articleMapper.selectAll();
        articles.forEach(System.out::println);
    }

    @Test
    public void selectLikeA() {
        String likeA = "a%";
        List<User> users = userMapper.selectLikeA(likeA);
        users.forEach(System.out::println);
    }


    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("d");
        user.setPassword("4");
        user.setNickname("滴滴");
        user.setBirthday(new Date());
        Integer result = userMapper.insertUser(user);
        System.out.println(result);
    }

    @Test
    public void deleteNewest() {
        Integer result = userMapper.deleteNewest();
        System.out.println(result);
    }

}