package dao;

import dto.MessageDto;
import models.MessageModel;

import java.util.List;

/**
 * Created by sameerap on 22/05/2017.
 */
public interface MessageDao extends BaseDao<MessageModel> {
    List<MessageModel> getMessagesBySender(MessageDto messageDto);
}
