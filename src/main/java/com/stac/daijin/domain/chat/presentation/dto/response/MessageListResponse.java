package com.stac.daijin.domain.chat.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MessageListResponse {

    private List<MessageResponse> messageList;

}
