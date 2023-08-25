package com.stac.daijin.domain.chat.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateRoomRequest {

    private List<String> participants;
}
