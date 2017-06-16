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
        boolean error = false;
        String errorMsg = null;

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");
        String password = req.getParameter("password");

        if (name == null || address == null || password == null) {
            error = true;
            errorMsg = "Data is incorrect";
        } else {

            try {
                System.out.println("HERE1");
                user = UserDAO.INSTANCE.findUser(name);

                if (user != null) {
                    System.out.println("HERE2");
                    error = true;
                    errorMsg = "User exist";

                }
            } catch (Exception e) {
                error = true;
                errorMsg = e.getMessage();
            }
        }

        if (!error) {
            user = new User(name, age, address, password);
            UserDAO.INSTANCE.insertUser(user);
            errorMsg = "SUCCESS!";
        }
        req.setAttribute("errorString", errorMsg);
        resp.reset();
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/registration.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
