package services;

import com.google.inject.Inject;
import dao.MessageDao;
import dto.MessageDto;
import models.MessageModel;
import models.UserModel;
import play.libs.Json;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MessageServiceImpl implements MessageService{
    @Inject
    MessageDao messageDao;

    @Override
    public void createMessage(MessageDto messageDto) {
        MessageModel messageModel = new MessageModel();
        messageModel.setSenderId(messageDto.getSenderId());
        messageModel.setRecieverId(messageDto.getRecieverId());
        messageModel.setMessageContent(messageDto.getMessageContent());
        messageModel.setRecievedOn(messageDto.getRecievedOn());
        System.out.println(Json.toJson(messageModel));
        messageModel = messageDao.add(messageModel);
    }

    @Override
    public List<MessageDto> getMessages(MessageDto messageDto) {
        List<MessageDto> messageDtoList = new ArrayList<>();
        List<MessageModel> messageModels = null;
        messageModels = messageDao.getMessagesBySender(messageDto);

        for (MessageModel messageModel : messageModels){
            MessageDto messageDto1 = new MessageDto();
            messageDto1.setMessageContent(messageModel.getMessageContent());
            messageDto1.setRecievedOn(messageModel.getRecievedOn());
            messageDto1.setRecieverId(messageModel.getRecieverId());
            messageDto1.setSenderId(messageModel.getSenderId());
            messageDto1.setMessageId(messageModel.getMessageId());

            messageDtoList.add(messageDto1);
        }

        return messageDtoList;
    }
}
