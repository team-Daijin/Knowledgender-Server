package com.stac.daijin.domain.chat.repository;

import com.stac.daijin.domain.chat.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableMongoRepositories
public interface RoomRepository extends MongoRepository<Room, String> {
    Optional<Room> findRoomById(String id);
}
