package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ApiDataSource class to represent API_DATA_SOURCE table
 *
 */
@Entity
@Table(name = "MESSAGES")
public class MessageModel extends Model {
    @Id
    @Column(name = "MESSAGE_ID",nullable = false)
    private int messageId;

    @Column(name = "SENDER_ID",nullable = false)
    private String senderId;

    @Column(name = "RECIEVER_ID",nullable = false)
    private String recieverId;

    @Column(name = "MESSAGE_CONTENT",nullable = false)
    private String messageContent;

    @Column(name = "RECIEVED_ON",nullable = false)
    private String recievedOn;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(String recieverId) {
        this.recieverId = recieverId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getRecievedOn() {
        return recievedOn;
    }

    public void setRecievedOn(String recievedOn) {
        this.recievedOn = recievedOn;
    }
}
