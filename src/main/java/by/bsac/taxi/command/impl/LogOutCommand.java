package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.Command;
import by.bsac.taxi.command.PagePath;
import by.bsac.taxi.command.ParametersAndAttribute;
import by.bsac.taxi.command.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Router router = new Router();
        if (session != null && session.getAttribute(ParametersAndAttribute.USER) != null) {
            session.invalidate();
            router.setPagePath(PagePath.TO_SIGN_IN_PAGE);

        }
            return router;
    }
}
