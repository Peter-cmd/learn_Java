package zero.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    // 复写添加拦截器的方法
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 添加一个LoginIntercepter类型的拦截器
//        registry.addInterceptor(new LoginInterceptor())
//                .excludePathPatterns("/api/1")
//                .excludePathPatterns("/views/login.html")
//                .excludePathPatterns("/views/index.html");
//    }

    // 复写配置路径匹配的方法
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 配置资源访问路径的上下文前缀
        configurer.addPathPrefix("api", c -> true);
    }
}
