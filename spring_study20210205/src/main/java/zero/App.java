package zero;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zero.dao.LoginRepository;
import zero.model.User;


public class App {
    private static final Log log = LogFactory.getLog(App.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        LoginRepository loginRepository1 = (LoginRepository) context.getBean("loginRepository");

//        LoginRepository loginRepository2 = context.getBean(LoginRepository.class);
//        LoginRepository loginRepository3 = context.getBean(LoginRepository.class);
//
//        System.out.println(loginRepository1 == loginRepository2);
//        System.out.println(loginRepository1 == loginRepository3);
//        System.out.println(loginRepository2 == loginRepository3);
//
//        User user1 = (User) context.getBean("user1");
//        User user2 = (User) context.getBean("user1");
//        System.out.println(user1 == user2);
//
//
        User user3 = (User)context.getBean("user1");
       // System.out.println(user3);
        log.info(user3);
        loginRepository1.isSingleton();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
