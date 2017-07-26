package filter;

import entity.User;
import servlets.LogginedUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by taras on 14.06.2017.
 */
@WebFilter("/myPage")
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginedUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            filterChain.doFilter(req, resp);
        }
    }

    public void destroy() {

    }
}
