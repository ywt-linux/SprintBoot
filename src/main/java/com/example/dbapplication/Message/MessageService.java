package com.example.dbapplication.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void addNewMessage(Message message) {
        Optional<Message> messageOptional = messageRepository
                .findMessageByCarNumber(message.getCarNumber());
        if (messageOptional.isPresent()) {
            throw new IllegalStateException("already received");
        }
        System.out.println(message);
        messageRepository.save(message);
    }

    public void deleteMessage(Long messageId) {
        boolean exists = messageRepository.existsById(messageId);
        if(!exists){
            throw new IllegalStateException("message with id " + messageId + " does not exist");
        }
        messageRepository.deleteById(messageId);
    }

    @Transactional
    public void updateMessage(Long messageId,
                              String name,
                              boolean status){
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new IllegalStateException(
                        "Message with id " + messageId + "not found"
                ));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(message.getName(), name)){
            message.setName(name);
        }

        message.setStatus(status);
    }

}
