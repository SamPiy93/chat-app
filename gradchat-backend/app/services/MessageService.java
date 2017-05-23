package services;

import dao.MessageDao;
import dto.MessageDto;

import java.util.List;

public interface MessageService {
    void createMessage(MessageDto messageDto);

    List<MessageDto> getMessages(MessageDto messageDto);
}
