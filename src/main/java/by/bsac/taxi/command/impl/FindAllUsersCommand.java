package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.Command;
import by.bsac.taxi.command.ParametersAndAttribute;
import by.bsac.taxi.command.Router;
import by.bsac.taxi.entity.User;
import by.bsac.taxi.model.dao.impl.UserDaoImpl;
import by.bsac.taxi.model.service.UserService;
import by.bsac.taxi.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class FindAllUsersCommand implements Command {

    private UserService userService = new UserServiceImpl(new UserDaoImpl());
    @Override
    public Router execute(HttpServletRequest request) {
        List<User> users = new ArrayList<>(userService.findAll());
        Router router = new Router();
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(ParametersAndAttribute.CURRENT_PAGE);
        session.setAttribute(ParametersAndAttribute.USER_LIST, users);
        router.setPagePath(currentPage);
        return router;
    }
}
