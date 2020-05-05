package zero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zero.mapper.UserMapper;
import zero.model.User;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public int insert(User user){
        return userMapper.insert(user);
    }

    public User selectByPrimaryKey(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
