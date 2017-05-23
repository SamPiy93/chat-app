package dao;

import com.avaje.ebean.Expr;
import dto.MessageDto;
import models.MessageModel;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by sameerap on 22/05/2017.
 */
public class MessageDaoImpl implements MessageDao {

    @Override
    public MessageModel add(MessageModel entity) {
        try {
            entity.save();
            System.out.println(entity);
        } catch(PersistenceException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return entity;
    }

    @Override
    public MessageModel update(MessageModel updateEntity) {
        return null;
    }

    @Override
    public boolean delete(MessageModel id) {
        return false;
    }

    @Override
    public List<MessageModel> getAllRecords() {
        return null;
    }

    @Override
    public MessageModel getDetailsById(Long id) {
        return null;
    }

    @Override
    public List<MessageModel> getMessagesBySender(MessageDto messageDto) {
        return MessageModel.find
                .where()
                .or(
                        Expr.and(Expr.eq("SENDER_ID", messageDto.getSenderId()), Expr.eq("RECIEVER_ID", messageDto.getRecieverId())),
                        Expr.and(Expr.eq("RECIEVER_ID", messageDto.getSenderId()), Expr.eq("SENDER_ID", messageDto.getRecieverId()))
                )
                .findList();
    }
}
