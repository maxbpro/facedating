package maxb.facedating.dao;

import maxb.facedating.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaxB on 07/11/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findByFacesetTokenAndFaceToken(String facesetToken, String faceToken);
}
