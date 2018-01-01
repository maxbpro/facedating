package maxb.facedating.service;

import maxb.facedating.domain.Chat;
import maxb.facedating.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessagesService {

    Page<Chat> findChats(Long userId, Pageable pageRequest);

    Page<Message> findMessages(Long chatId, Pageable pageRequest);

    Chat findChatById(Long chatId);

    Chat findChat(Long userId, Long senderId);

    void saveMessage(Message message);

    void saveChat(Chat chat);
}
