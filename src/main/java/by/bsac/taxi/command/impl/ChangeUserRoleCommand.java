package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.*;
import by.bsac.taxi.entity.User;
import by.bsac.taxi.model.dao.impl.UserDaoImpl;
import by.bsac.taxi.model.service.UserService;
import by.bsac.taxi.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeUserRoleCommand implements Command {

    private UserService userService = new UserServiceImpl(new UserDaoImpl());
    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(ParametersAndAttribute.CURRENT_PAGE);

        long userId = Long.parseLong(request.getParameter(ParametersAndAttribute.USER_ID));
        boolean isChanged = userService.changeUserRole(userId, User.Role.ADMIN);
        router.setPagePath(currentPage);

        if (isChanged) {
            session.setAttribute(ParametersAndAttribute.MESSAGE, Message.SUCCESSFUL);
        } else {
            session.setAttribute(ParametersAndAttribute.MESSAGE, Message.UNSUCCESSFUL);
        }
        return router;
    }
}
