package com.example.androidlabs1;

public class Message {
//    enum ChatType {
//        SEND,
//        RECEIVE
//    }

    protected long id;

    private String chatMessage;

    private Boolean isSent;

//    public ChatType chatType;

    /** Constructor */
//    public Message(String text, ChatType chat, long i){
//        this.chatMessage = text;
//        this.chatType = chat;
//        this.id = i;
//    }

    Message(String text, Boolean chatType, long i){
        this.chatMessage = text;
        this.isSent = chatType;
        this.id = i;
    }

//    public void update(String text, ChatType chat){
//        chatMessage = text;
//        chatType = chat;
//    }

    public void update(String text, Boolean chatType){
        chatMessage = text;
        isSent = chatType;
    }

    /** Chaining Constructor */
//    public Message(String text, ChatType chat){ this(text, chat, 0); }

    public Message(String text, Boolean chatType){ this(text, chatType, 0); }

    String getChatMessage(){
        return chatMessage;
    }

    Boolean getChatType(){
        return isSent;
    }

    public long getId() { return id; }


}