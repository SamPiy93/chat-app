package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO to handle API Environments
 *
 */
@JsonPropertyOrder({"MESSAGE_ID", "SENDER_ID", "RECIEVER_ID", "MESSAGE_CONTENT", "RECIEVED_ON"})
public class MessageDto {

    @JsonProperty("MESSAGE_ID")
    private int messageId;

    @JsonProperty("SENDER_ID")
    private String senderId;

    @JsonProperty("RECIEVER_ID")
    private String recieverId;

    @JsonProperty("MESSAGE_CONTENT")
    private String messageContent;

    @JsonProperty("RECIEVED_ON")
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
