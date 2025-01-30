package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

import javassist.tools.web.BadHttpRequest;

@Service
public class MessageService {
    //private AccountService accountService;

    private MessageRepository messageRepository;
    @Autowired
    public MessageService (MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    /*Method to Create new messages */
    public Message createMessage(Message message) throws ResponseStatusException{ //added postedBy exists by checking is message is not null
        if (message != null && message.getMessageText() != "" && message.getMessageText().length() < 255) { 
            if (messageRepository.existsById(message.getPostedBy())){
                return messageRepository.save(message);
            }
            else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    /*Method to Get all messages */
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    /*Method to Get a message by ID */
    public Message getMessageById (Integer messageId){
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        if(messageOptional.isPresent()){
            return messageOptional.get();
        } else{
            return null;
        }
    }

    /*Method to Delete a message by ID */
    public long deleteMessageById (Integer messageId){
        if (messageRepository.existsById(messageId)){
            messageRepository.deleteById(messageId);
            return 1;
        }else{
            return 0;//has to be empty;
        }
    }

    /*Method to Update a message by ID */
    public long updateMessageById (Integer MessageId, Message newMessage){
        if (newMessage.getMessageText() == "" || newMessage.getMessageText().length() > 255){
            return 0;
        }
        Optional<Message> messageOptional = messageRepository.findById(MessageId);
        if (messageOptional.isPresent()){
            Message message = messageOptional.get();
            message.setMessageText(newMessage.getMessageText());
            messageRepository.save(message);
            return 1;
        }else{
            return 0;
        }
    }

    /*Method to Get all Messages from a particular accountId/posted_by */ //might need custom query in repository
    public Message getMessageByPostedBy(Integer postedBy){
        Optional<Message> messageOptional = messageRepository.findMessageByPostedBy(postedBy);
        if (messageOptional.isPresent()){
            return messageOptional.get();
        }else{
            return null;
        }
    }

}
