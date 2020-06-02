package zero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zero.mapper.UserMapper;
import zero.model.User;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}
