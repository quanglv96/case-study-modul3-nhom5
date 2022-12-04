package Controller;

import DAO.NewsDAO;
import Model.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private NewsDAO newsDAO = new NewsDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                listNews(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void listNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> listNews = newsDAO.selectAllNews();
        request.setAttribute("listNews", listNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/View.jsp");
        dispatcher.forward(request, response);
    }
}
