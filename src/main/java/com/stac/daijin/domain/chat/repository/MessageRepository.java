package com.stac.daijin.domain.chat.repository;

import com.stac.daijin.domain.chat.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
public interface MessageRepository extends MongoRepository<Message, String> {
}
