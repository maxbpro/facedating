package maxb.facedating.dao;

import maxb.facedating.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaxB on 27/11/2017.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findByChatId(Long chatId, Pageable pageRequest);

}
