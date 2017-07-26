package servlets;

import com.db.UserDAO;
import entity.Item;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/myPage")
public class MyPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> list;

        HttpSession session = req.getSession();
        User logginedUser = LogginedUser.getLoginedUser(session);

        req.setAttribute("user", logginedUser);

        list = UserDAO.INSTANCE.getItems(logginedUser.getUserID());

        req.setAttribute("itemList", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/myPage.jsp");
        dispatcher.forward(req, resp);
    }
}
