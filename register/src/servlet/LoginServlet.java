package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import vo.User;

public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String surePassWord = request.getParameter("surePassword");
        //用户输入不能为空

    }

}
