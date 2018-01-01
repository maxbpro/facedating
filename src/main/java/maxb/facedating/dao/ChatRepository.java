package maxb.facedating.dao;

import maxb.facedating.domain.Chat;
import maxb.facedating.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaxB on 27/11/2017.
 */
public interface ChatRepository extends JpaRepository<Chat, Long> {

    Page<Chat> findByUserId(Long userId, Pageable pageRequest);

    Chat findOneByUserIdAndSenderId(Long userId, Long senderId);
}
