package maxb.facedating.service;


import maxb.facedating.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by MaxB on 07/11/2017.
 */

public interface UserService {


    void save(User user);

    User update(User user);

    User findByUsername(String username);

    User findByUserId(Long id);

    List<User> listUsers();

    Page<User> getUser(Integer pageNumber);
}
