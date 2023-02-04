package by.bsac.taxi.command;

public final class PagePath {

    public static final String SIGN_IN = "/jsp/signin.jsp";
    public static final String HOME = "/jsp/home.jsp";
    public static final String ADMIN = "/jsp/admin.jsp";
    public static final String USER = "/jsp/user.jsp";
    public static final String SIGN_UP = "/jsp/signup.jsp";

    public static final String TO_SIGN_UP_PAGE = "/controller?command=to_sign_up";
    public static final String TO_SIGN_IN_PAGE = "/controller?command=to_sign_in";

    private PagePath(){}

}
