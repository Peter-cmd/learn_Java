package Zero.scan;

import Zero.ioc.Duck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Conf {

    @Bean
    public Duck duck5(){
        return new Duck("鸭子5号");
    }

    @Bean("duck6")
    public Duck duck0(){
        return new Duck("鸭子6号");
    }

}
