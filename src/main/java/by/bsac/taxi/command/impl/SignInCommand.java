package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.*;
import by.bsac.taxi.entity.User;
import by.bsac.taxi.model.dao.impl.TaxiDaoImpl;
import by.bsac.taxi.model.dao.impl.UserDaoImpl;
import by.bsac.taxi.model.service.TaxiService;
import by.bsac.taxi.model.service.UserService;
import by.bsac.taxi.model.service.impl.TaxiServiceImpl;
import by.bsac.taxi.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static by.bsac.taxi.entity.User.Role.ADMIN;

public class SignInCommand implements Command {

    private UserService userService = new UserServiceImpl(new UserDaoImpl());
    private TaxiService taxiService = new TaxiServiceImpl(new TaxiDaoImpl());

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        HttpSession session = request.getSession();

        String email = request.getParameter(ParametersAndAttribute.EMAIL);
        String password = request.getParameter(ParametersAndAttribute.USER_PASSWORD);
        User user = null;
        Optional<User> optionalUser;

        optionalUser = userService.findUserByEmailAndPassword(email, password);

        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            router.setPagePath(defineUserRole(user));
            session.setAttribute(ParametersAndAttribute.USER, user);
            session.setAttribute(ParametersAndAttribute.TAXI_LIST, taxiService.findAll());
            session.setAttribute(ParametersAndAttribute.CURRENT_PAGE, router.getPagePath());
        } else {
            router.setPagePath(PagePath.SIGN_IN);
            request.setAttribute(ParametersAndAttribute.MESSAGE, Message.INCORRECT_PASSWORD_OR_EMAIL);
        }

        return router;
    }

    private static String defineUserRole(User user) {

        if (user.getRole() == ADMIN) {
            return PagePath.ADMIN;
        }

        return PagePath.USER;
    }
}
