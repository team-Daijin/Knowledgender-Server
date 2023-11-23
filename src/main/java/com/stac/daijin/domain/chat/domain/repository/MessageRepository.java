package com.stac.daijin.domain.chat.domain.repository;

import com.stac.daijin.domain.chat.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface MessageRepository extends MongoRepository<Message, String> {

    Page<Message> findAllByRoomId(String roomId, Pageable pageable);
}
