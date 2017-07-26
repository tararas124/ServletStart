package servlets;


import com.db.UserDAO;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forget")
public class ForgetPass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean error = false;
        User user = null;
        String message = "";
        String name = req.getParameter("login");
        String address = req.getParameter("address");
        int age = 0;

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400);
            error = true;
            return;
        }

        if (name == null || address == null || error) {
            error = true;
            System.out.println("HERE@");
            resp.sendError(400);
            return;
        } else {
            try {
                user = UserDAO.INSTANCE.findUser(name, age, address);
            } catch (Exception e) {
                resp.sendError(400);
                return;
            }
        }

        if (user == null) {
            message = "Data is not correct";
        } else {
            message = "Password is: " + user.getPassword();
        }

        req.setAttribute("message", message);

//        resp.sendRedirect(req.getContextPath() + "/login");
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
