package by.bsac.taxi.controller;

import by.bsac.taxi.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandFromPage = req.getParameter(ParametersAndAttribute.COMMAND);
        Command currentCommand = CommandProvider.defineCommand(commandFromPage);
        Router router = currentCommand.execute(req);

        switch (router.getType()) {
            case FORWARD: {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(router.getPagePath());
                requestDispatcher.forward(req, resp);
                break;
            }
            case REDIRECT: {
                resp.sendRedirect(router.getPagePath());
                break;
            }
            default: {
                resp.sendRedirect(PagePath.SIGN_IN);
            }
        }
    }
}
