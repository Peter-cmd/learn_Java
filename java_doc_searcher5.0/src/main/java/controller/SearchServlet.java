package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import searcher.Result;
import searcher.Searcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchServlet extends HttpServlet {
    private Searcher searcher = new Searcher();

    Gson gson = new GsonBuilder().create();

    public SearchServlet() throws IOException {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        String query = req.getParameter("query");
        if (query == null || "".equals(query.trim())){
            resp.setStatus(404);
            resp.getWriter().print("query 参数非法.");
            return;
        }

        List<Result> resultList = searcher.search(query.trim().toLowerCase());
        String respString = gson.toJson(resultList);
        resp.getWriter().print(respString);


    }
}
