package Controller;

import DAO.UserDAO;
import Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "check":
                checkValidate(request, response);
                break;
        }
    }

    public void checkValidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = 0;
        String username = request.getParameter("userName");
        Pattern patternUserName = Pattern.compile("^[a-zA-Z0-9]+");
        Matcher matcherUserName = patternUserName.matcher(username);
        if (!matcherUserName.matches()) {
            request.setAttribute("checkUser", "*Username without spaces");
            count++;
        }
        List<User> listUser=userDAO.findAll();
        for (User u: listUser){
            if(username.equals(u.getUserName())){
                request.setAttribute("checkUser", "*Username available");
                count++;
                break;
            }
        }
        String password = request.getParameter("password");
        Pattern patternPass = Pattern.compile("^[a-zA-z0-9]{6,50}$");
        Matcher matcherPass = patternPass.matcher(password);
        if (!matcherPass.matches()) {
            request.setAttribute("checkPass", "*Password must be at least 6 characters and no spaces");
            count++;
        }
        String rePassword = request.getParameter("rePassword");
        if (!rePassword.equals(password)) {
            request.setAttribute("checkRePass", "*RePassword don't match password");
            count++;
        }
        String phoneNumber = request.getParameter("phoneNumber");
        Pattern patternPhone = Pattern.compile("^0[1-9][0-9]{8}$");
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        if (!matcherPhone.matches()) {
            request.setAttribute("checkPhone", "*Your phone number is incorrect");
            count++;
        }
        String email = request.getParameter("email");
        Pattern patternEmail = Pattern.compile("^(.+)@(.+)$");
        Matcher matcherEmail = patternEmail.matcher(email);
        if (!matcherEmail.matches()) {
            request.setAttribute("checkEmail", "*Your email is incorrect");
            count++;
        }
        String address = request.getParameter("address");
        if (count != 0) {
            request.setAttribute("userName", username);
            request.setAttribute("phoneNumber", phoneNumber);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/Register.jsp");
            dispatcher.forward(request, response);
        } else {
            User user;
            user = new User(username, password, phoneNumber, email, address, 1);
            userDAO.insertUser(user);
        }
    }

}
