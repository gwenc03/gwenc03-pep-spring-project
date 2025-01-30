package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

import javassist.tools.web.BadHttpRequest;


/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    private final AccountService accountService;

    private final MessageService messageService;

    @Autowired
    public SocialMediaController (AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }

    /* Registration */
    @PostMapping("/register")
    //     public Account registerAccount (Account newAccount){
    //     return null;
    // }
    public ResponseEntity<Account> registerAccount(@RequestParam String username, @RequestParam String password){
        //call accountService
        return null;
    }
    

    /*Login */
    @PostMapping("/login")
    public Account verifyAccountLogin (@RequestBody Account account){
        return null;
    }

    /*Message Creation */
    @PostMapping("/messages")
    public ResponseEntity<Message> createNewMessage(@RequestBody Message message) throws ResponseStatusException{
        Message createdMessage = messageService.createMessage(message);
        return new ResponseEntity<>(createdMessage, HttpStatus.OK);
    }

    /*Get All Messages */
    @GetMapping("/messages")
    public Message getAllMessages(){
        return null;
    }

    /*Get a message by ID */
    @GetMapping("/messages/{messageId}")
    public Message getMessagebyId (@PathVariable Integer messageId){
        return null;
    }

    /*Delete a message by ID */
    @DeleteMapping("/messages/{messageId}")
    public ResponseEntity<Long> deleteMessagebyId (@PathVariable Integer messageId){
        long rowsDeleted = messageService.deleteMessageById(messageId);
        if (rowsDeleted > 0){
            return ResponseEntity.ok(rowsDeleted);
        }else{
            return ResponseEntity.ok().build();
        }
    }

    /*Update a message by ID */
    @PatchMapping("/messages/{messageId}")
    public Message updateMessagebyId (@PathVariable Integer messageId){
        return null;
    }


    /*Get all Messages from a particular accountId/posted_by */
    @GetMapping("/accounts/{accountId}/messages")
    public Message getAllMessagesbyAccountId (@PathVariable Integer accountId){
        return null;
    }

}
