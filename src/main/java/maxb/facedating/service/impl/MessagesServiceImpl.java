package maxb.facedating.service.impl;

import maxb.facedating.dao.ChatRepository;
import maxb.facedating.dao.MessageRepository;
import maxb.facedating.domain.Chat;
import maxb.facedating.domain.Message;
import maxb.facedating.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;


    @Override
    public Page<Chat> findChats(Long userId, Pageable pageRequest) {
        return chatRepository.findByUserId(userId, pageRequest);
    }

    @Override
    public Page<Message> findMessages(Long chatId, Pageable pageRequest) {
        return messageRepository.findByChatId(chatId, pageRequest);
    }

    @Override
    public Chat findChatById(Long chatId){
        return chatRepository.findOne(chatId);
    }


    @Override
    public void saveChat(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Chat findChat(Long userId, Long senderId){
        return chatRepository.findOneByUserIdAndSenderId(userId, senderId);
    }
}
