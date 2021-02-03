package zero.configure;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取当前用户的session
        HttpSession session = request.getSession(false);
        // 若当前用户的session存在返回true, 即用户已经登录
        if (session != null) {
            return true;
        }
        // 用户未登录, 设置响应状态码
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }
}
