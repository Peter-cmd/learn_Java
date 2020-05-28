package zero.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import zero.model.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}