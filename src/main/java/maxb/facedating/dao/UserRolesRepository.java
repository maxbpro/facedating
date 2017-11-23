package maxb.facedating.dao;

import maxb.facedating.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaxB on 11/11/2017.
 */
public interface UserRolesRepository extends JpaRepository<Role, Long> {

//    @Query("select userRole.role from Role userRole, User user where user.username=?1 and userRole.username=user.username")
//    public List<String> findRoleByUserName(String username);
}
