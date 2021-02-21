package org.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.study.model.Article;

@Mapper
@Component
public interface ArticleMapper {
    Article selectById(Integer id);
}
