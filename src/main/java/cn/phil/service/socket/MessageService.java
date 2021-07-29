package cn.phil.service.socket;

import cn.phil.model.socket.Message;
import cn.phil.repo.socket.MessageRepository;
import cn.phil.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author phil
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    RedisService redisService;

    public Message insertMessage(Message message) {
        return messageRepository.save(message);
    }
    public List<Message> insertMessages(List<Message> messages) {
        Iterable<Message> ret = messageRepository.saveAll(messages);
        List<Message> res = new ArrayList<>();
        ret.forEach(res::add);
        return res;
    }

    public List<Message> getNoReadMessagesFromDB(Long userId) {
        return messageRepository.findByDesUserIdAndAlreadySent(userId, false);
    }
}