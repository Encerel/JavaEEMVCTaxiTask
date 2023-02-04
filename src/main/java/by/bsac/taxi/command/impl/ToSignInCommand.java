package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.Command;
import by.bsac.taxi.command.PagePath;
import by.bsac.taxi.command.Router;

import javax.servlet.http.HttpServletRequest;

public class ToSignInCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPagePath(PagePath.SIGN_IN);
        return router;
    }
}
