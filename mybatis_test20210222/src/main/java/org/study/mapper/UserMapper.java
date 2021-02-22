package org.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.study.model.Article;
import org.study.model.User;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    User selectById(Integer id);

    List<User> selectAll();

    List<User> selectLikeA(String likeA);

    Integer insertUser(User user);

    Integer deleteNewest();
}
