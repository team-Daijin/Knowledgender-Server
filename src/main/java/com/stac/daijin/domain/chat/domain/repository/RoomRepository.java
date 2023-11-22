package com.stac.daijin.domain.chat.domain.repository;

import com.stac.daijin.domain.chat.domain.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@EnableMongoRepositories
public interface RoomRepository extends MongoRepository<Room, String> {
    Optional<Room> findRoomById(String id);
}
