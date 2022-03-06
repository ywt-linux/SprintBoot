package com.example.dbapplication.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository
        extends JpaRepository<Message, Long> {

//    SELECT * FROM messages WHERE car number = ?
    @Query("SELECT m FROM Message m WHERE m.carNumber = ?1")
    Optional<Message> findMessageByCarNumber(String carNumber);
}
