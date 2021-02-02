package zero;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zero.model.User;

import java.util.List;
import java.util.Set;


public class AppXml {
    private static final Log log = LogFactory.getLog(AppXml.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User)context.getBean("user2");

//        System.out.println(user.getId() + " " + user.getName());

//        List<User> focus = user.getFocus();
//        for (User u : focus) {
//            System.out.println(u.getId() + " " + u.getName());
//        }
//
//        System.out.println("==================");
//
//        User user2 = (User)context.getBean("user2");
//        System.out.println("boyFriend: " + user2.getBoyFriend().getName());
//        Set<User> followers = user2.getFollowers();
//        for (User u : followers) {
//            System.out.println(u.getId() + " " + u.getName());
//        }
    }
}
