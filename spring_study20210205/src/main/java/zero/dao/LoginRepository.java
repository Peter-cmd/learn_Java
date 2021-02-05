package zero.dao;

import org.springframework.stereotype.Repository;
import zero.model.User;

import javax.annotation.Resource;

@Repository
public class LoginRepository {

    @Resource(name = "user1")
    private User user2;

    @Resource(type = User.class)
    private User user1;

    public void isSingleton() {
        System.out.println(user1 == user2);
    }


}
