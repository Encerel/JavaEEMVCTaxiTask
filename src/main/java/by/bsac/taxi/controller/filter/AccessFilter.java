package by.bsac.taxi.controller.filter;

import by.bsac.taxi.command.PagePath;
import by.bsac.taxi.command.ParametersAndAttribute;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "AccessFilter", dispatcherTypes = { DispatcherType.REQUEST,
        DispatcherType.FORWARD }, urlPatterns = "*.jsp")
public class AccessFilter implements Filter {
    private static final Set<String> ALLOWED_PATH_USER = new HashSet<>(
            Arrays.asList("/index.jsp", "/jsp/signin.jsp", "/jsp/signup.jsp", "/jsp/error.jsp"));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String pagePath = req.getServletPath();
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute(ParametersAndAttribute.USER) != null);
        boolean allowedPath = ALLOWED_PATH_USER.contains(pagePath);
        if (loggedIn || allowedPath) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getContextPath() + PagePath.TO_SIGN_IN_PAGE);
        }
    }
}