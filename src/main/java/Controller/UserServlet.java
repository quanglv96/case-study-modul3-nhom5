package Controller;

import DAO.NewsDAO;
import DAO.UserDAO;
import Model.News;
import Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
//

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private NewsDAO newsDAO = new NewsDAO();
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "contentByID":
                contentByID(request, response);
            default:
                listNews(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                checkLogin(request, response);
                break;
            case "sort":
                sortByCategory(request, response);
            default:
                listNews(request, response);
                break;
        }
    }

    public void listNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> listNews = newsDAO.selectAllNews();
        String idLogin = request.getParameter("idUser");
        request.setAttribute("listNews", listNews);
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/View.jsp");
        dispatcher.forward(request, response);
    }

    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> listUser = userDAO.findAll();
        boolean flag = true;
        for (User u : listUser) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                flag = false;
                request.setAttribute("idLogin", u.getIdUser());
                RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/View.jsp");
                dispatcher.forward(request, response);
            }
        }
        if (flag) {
            request.setAttribute("checkLogin", "Username or Password is incorrect");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/loginUser.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void contentByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idNews = Integer.parseInt(request.getParameter("idNews"));
        String idLogin = request.getParameter("idUser");
        request.setAttribute("newById", newsDAO.selectNews(idNews));
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_news/content_news_byID_manager.jsp");
        dispatcher.forward(request, response);
    }

    public void sortByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("idCategory");
       String idLogin = request.getParameter("idUser");
        List<News> listNews=newsDAO.selectNewsByCategory(category);
        request.setAttribute("listNews", listNews);
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/View.jsp");
        dispatcher.forward(request, response);
    }

}
