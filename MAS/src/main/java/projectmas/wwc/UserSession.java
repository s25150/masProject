package projectmas.wwc;

public class UserSession {
    private static String userLogin;

    public static void setUserLogin(String login) {
        userLogin = login;
    }

    public static String getUserLogin() {
        return userLogin;
    }
}
