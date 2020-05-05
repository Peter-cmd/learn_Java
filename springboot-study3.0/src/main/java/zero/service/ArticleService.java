package zero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zero.mapper.ArticleMapper;
import zero.model.Article;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public Article queryArticleById(Long id){
        return articleMapper.queryArticleById(id);
    }
}
