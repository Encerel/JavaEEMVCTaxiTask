package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.Command;
import by.bsac.taxi.command.PagePath;
import by.bsac.taxi.command.ParametersAndAttribute;
import by.bsac.taxi.command.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToSignUpCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        HttpSession session = request.getSession();

        session.setAttribute(ParametersAndAttribute.CURRENT_PAGE, PagePath.TO_SIGN_UP_PAGE);
        router.setPagePath(PagePath.SIGN_UP);
        return router;
    }
}
