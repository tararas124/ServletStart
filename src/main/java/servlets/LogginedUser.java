package servlets;

import entity.User;

import javax.servlet.http.HttpSession;

public class LogginedUser {
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    public static User getLoginedUser(HttpSession session) {
        return (User) session.getAttribute("loginedUser");
    }

    public static void signOutUser(HttpSession session) {
        if (session == null || getLoginedUser(session) == null) {
            return;
        }
        session.removeAttribute("loginedUser");
    }
}
