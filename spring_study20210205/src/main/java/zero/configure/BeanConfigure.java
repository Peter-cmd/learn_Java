package zero.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zero.model.User;

@Configuration
public class BeanConfigure {
    @Bean
    public User user1() {
        User user = new User();
        user.setId(1);
        user.setName("李华");
        return user;
    }


    @Bean
    public User user2() {
        User user = new User();
        user.setId(2);
        user.setName("刘丽");
        return user;
    }
}
