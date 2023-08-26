package com.stac.daijin.domain.chat.repository;

import com.stac.daijin.domain.chat.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableMongoRepositories
public interface MessageRepository extends MongoRepository<Message, String> {

    Page<Message> findAllByRoomId(String roomId, Pageable pageable);
}
