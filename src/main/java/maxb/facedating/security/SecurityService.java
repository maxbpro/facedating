package maxb.facedating.security;

/**
 * Created by MaxB on 11/11/2017.
 */
public interface SecurityService {

    String findLoggedInUsername();
    void autologin(String username, String password);
}
