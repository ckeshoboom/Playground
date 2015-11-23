package com.boomtown.ckesho.playground.Models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ckesho on 11/19/2015.
 */
public class MessageCreator {

    //Constructor
    public MessageCreator(int numberOfMessages){
        list=new ArrayList<Message>();
        for(int count=0;count<numberOfMessages;count++){
            list.add(getMessage());
        }
    };
    ArrayList<Message> list;

    public ArrayList<Message> getList(){
        return list;
    }

    Message getMessage(){
        Random random=new Random();
        Message message= new Message();
        message.identification=""+random.nextInt();
        message.viewitemtype=(int)(Math.random()*10);


        return message;
    }

    void setList (int number){}
}
