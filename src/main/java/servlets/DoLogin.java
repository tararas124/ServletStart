package servlets;

import com.db.DBConnection;
import com.db.UserDAO;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by taras on 14.06.2017.
 */

@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        boolean error = false;
        String errorMsg = null;

        String name = req.getParameter("login");
        String password = req.getParameter("password");

        if (name == null || password == null
                || name.length() == 0 || password.length() == 0) {
            error = true;
            errorMsg = "Required username and password!";
        } else {
            user = UserDAO.INSTANCE.findUser(name, password);

            if (user == null) {
                error = true;
                errorMsg = "User name or password is not correct";
            }
        }

        if (error) {
            user = new User();
            user.setName(name);
            user.setPassword(password);

            req.setAttribute("errorString", errorMsg);
            req.setAttribute("user", user);

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            HttpSession session = req.getSession();

            LogginedUser.storeLoginedUser(session, user);
            resp.sendRedirect(req.getContextPath() + "/myPage");
        }

    }
}
