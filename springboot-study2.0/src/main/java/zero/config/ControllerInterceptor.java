package zero.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import zero.model.Duck;

@ControllerAdvice
@Configuration
public class ControllerInterceptor {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Duck handel(){
        return new Duck("异常鸭子", 100);
    }
}
