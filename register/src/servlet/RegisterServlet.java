package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import vo.User;

public class RegisterServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String surePassword = request.getParameter("surePassword");
        //用户输入不能为空
        if (userName != null && !userName.trim().equals(" ")
                && password != null && !password.trim().equals(" ")
                && surePassword != null && !surePassword.trim().equals(" ")
                && password.equals(surePassword)){
            //若用户两次输入的密码相等
            if (password.equals(surePassword)){
                UserDao dao = new UserDao();
                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                try {
                    dao.insertUser(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            response.sendRedirect("login.jsp");
        }
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException{
        this.doGet(request,response);
    }

}
