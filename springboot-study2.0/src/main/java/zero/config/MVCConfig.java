package zero.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    /**
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //除了login.html 和 /user/login,两个url请求外,其他全被拦截
        //所有的拦截器依次执行
        //interceptor.preHandle() ---> controller.映射方法() ---> interceptor.postHandel()

        registry.addInterceptor(new LoginIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/error");
    }
}
