package com.stac.daijin.domain.chat;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Builder
@Document
@Getter
public class Room {

    @Id
    private String id;
    private String name;
    private List<String> participants;

    public void addParticipants(String accountId) {
        participants.add(accountId);
    }

}
