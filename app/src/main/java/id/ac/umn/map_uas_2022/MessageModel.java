package id.ac.umn.map_uas_2022;

import java.util.Date;

public class MessageModel {

    public String message;
    public int messageType;
    public Date messageTime = new Date();
    // Constructor
    public MessageModel(String message, int messageType) {
        this.message = message;
        this.messageType = messageType;
    }
}