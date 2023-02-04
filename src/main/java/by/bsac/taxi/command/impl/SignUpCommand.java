package by.bsac.taxi.command.impl;

import by.bsac.taxi.command.*;
import by.bsac.taxi.model.dao.impl.UserDaoImpl;
import by.bsac.taxi.model.service.UserService;
import by.bsac.taxi.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SignUpCommand implements Command {

    private UserService userService = new UserServiceImpl(new UserDaoImpl());

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        HttpSession session = request.getSession();
        Map<String, String> userData = new HashMap<>();

        String userName = request.getParameter(ParametersAndAttribute.USER_NAME);
        String userSurname = request.getParameter(ParametersAndAttribute.USER_SURNAME);
        String userEmail = request.getParameter(ParametersAndAttribute.EMAIL);
        String userPassword = request.getParameter(ParametersAndAttribute.USER_PASSWORD);
        String userRepeatPassword = request.getParameter(ParametersAndAttribute.CONFIRMED_PASSWORD);

        if (userPassword.equals(userRepeatPassword)) {
            if (userService.findUserByEmail(userEmail).isEmpty()) {
                userData.put(ParametersAndAttribute.USER_NAME, userName);
                userData.put(ParametersAndAttribute.USER_SURNAME, userSurname);
                userData.put(ParametersAndAttribute.EMAIL, userEmail);
                userData.put(ParametersAndAttribute.USER_PASSWORD, userPassword);
                if (userService.addUser(userData)) {
                    router.setPagePath(PagePath.SIGN_IN);
                    request.setAttribute(ParametersAndAttribute.MESSAGE, Message.SUCCESSFULLY_REGISTRATION);
                } else {
                    router.setPagePath(PagePath.SIGN_IN);
                    request.setAttribute(ParametersAndAttribute.MESSAGE, Message.UNSUCCESSFULLY_REGISTRATION);
                }
            } else {
                request.setAttribute(ParametersAndAttribute.MESSAGE, Message.SUCH_USER_IS_EXIST);
            }

        } else {
            router.setPagePath(PagePath.SIGN_UP);
            request.setAttribute(ParametersAndAttribute.MESSAGE, Message.PASSWORD_AND_CONFIRMED_PASSWORD_DONT_MATCH);
        }

        return router;
    }
}
