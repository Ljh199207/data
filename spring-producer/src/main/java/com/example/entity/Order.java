package com.example.entity;

import java.io.Serializable;

/**
 * @Auther: ljh
 * @Date: 2018/9/28 14:28
 * @Description:
 */
public class Order implements Serializable {

    private  String id;
    private  String name;
    private String messageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Order() {
    }

    public Order(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }
}
