package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
public class MessageModel extends Model {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_SEQ")
    @Column(name = "MESSAGE_ID",nullable = false)
    private Long messageId;

    @Column(name = "SENDER_ID",nullable = false)
    private String senderId;

    @Column(name = "RECIEVER_ID",nullable = false)
    private String recieverId;

    @Column(name = "MESSAGE_CONTENT",nullable = false)
    private String messageContent;

    @Column(name = "RECIEVED_ON",nullable = false)
    private String recievedOn;

    public static Finder<Long, MessageModel> find = new Finder<Long, MessageModel>(MessageModel.class);

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageModel that = (MessageModel) o;

        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) return false;
        if (senderId != null ? !senderId.equals(that.senderId) : that.senderId != null) return false;
        if (recieverId != null ? !recieverId.equals(that.recieverId) : that.recieverId != null) return false;
        if (messageContent != null ? !messageContent.equals(that.messageContent) : that.messageContent != null)
            return false;
        return recievedOn != null ? recievedOn.equals(that.recievedOn) : that.recievedOn == null;

    }

    @Override
    public int hashCode() {
        int result = messageId != null ? messageId.hashCode() : 0;
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recieverId != null ? recieverId.hashCode() : 0);
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (recievedOn != null ? recievedOn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "messageId=" + messageId +
                ", senderId='" + senderId + '\'' +
                ", recieverId='" + recieverId + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", recievedOn='" + recievedOn + '\'' +
                '}';
    }
}
