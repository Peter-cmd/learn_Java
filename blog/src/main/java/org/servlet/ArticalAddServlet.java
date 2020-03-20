package org.servlet;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.NestedParticle;
import org.model.Article;
import org.model.Result;
import org.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/articleAdd")
public class ArticalAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("appliction/json; charset=UTF-8");
        Result result = new Result();
        PrintWriter pw = resp.getWriter();
        try {
            //请求JSON数据转变为java对象(反序列化)
            Article article = JSONUtil.deserialize(req.getInputStream(), Article.class);
            System.out.println("请求的数据" + article);

            result.setSuccess(true);
            result.setCode("200xx");
            result.setMessage("Ok");
        }catch(IOException e){
            result.setCode("500xx");  //500xx 自定义的错误码
            result.setMessage("服务器出错了!");
        }
        pw.println(JSONUtil.serialize(result));
        pw.flush();

    }
}
