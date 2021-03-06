package servlets;

import com.db.DBConnection;
import com.db.UserDAO;
import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import entity.User;
import sun.plugin.com.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/doRegistr")
public class DoRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        String errorMsg = null;

        String name = req.getParameter("name");
        int age = 0;
        String address = req.getParameter("address");
        String password = req.getParameter("password");

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400);
            return;
        }

        if (name == null || address == null || password == null) {
            resp.sendError(400);
            return;
        } else {
            try {
                user = UserDAO.INSTANCE.findUser(name);
             } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(400);
                return;
            }
        }

        if (user != null) {
            errorMsg = "User exist!";
        } else {
            user = new User(name, age, address, password);
            UserDAO.INSTANCE.insertUser(user);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/welcome");
            dispatcher.forward(req, resp);
        }
        req.setAttribute("errorString", errorMsg);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/regist");
        dispatcher.forward(req, resp);
//        resp.sendRedirect(req.getContextPath() + "/regist");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
