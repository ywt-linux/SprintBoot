package com.example.dbapplication.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping()
    public List<Message> getMessages(){
        return messageService.getMessages();
    }

    @PostMapping
    public void uploadNewMessage(@RequestBody Message message) {
        messageService.addNewMessage(message);
    }

    @DeleteMapping(path="{messageId}")
    public void deleteMessage(@PathVariable("messageId") Long messageId) {
        messageService.deleteMessage(messageId);
    }

    @PutMapping(path="{messageId}")
    public void updateMessage(
            @PathVariable("messageId") Long messageId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) boolean status
    ) {
        messageService.updateMessage(messageId, name, status);
    }

}
