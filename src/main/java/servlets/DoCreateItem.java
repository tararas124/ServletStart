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

/**
 * Created by taras on 14.06.2017.
 */

@WebServlet("/doCreateItem")
public class DoCreateItem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        Item item = null;
        int state = 0;

        String text = req.getParameter("text");

        try {
            state = Integer.parseInt(req.getParameter("state"));
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400);
            return;
        }
        if (text == null) {
            resp.sendError(400);
        }

        HttpSession session = req.getSession();
        user = LogginedUser.getLoginedUser(session);

        item = new Item(text, state, user.getUserID());
        UserDAO.INSTANCE.insertItem(item);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/myPage");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
