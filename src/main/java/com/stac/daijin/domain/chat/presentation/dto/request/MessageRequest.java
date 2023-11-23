package com.stac.daijin.domain.chat.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

    @NotNull
    private String message;
    @NotNull
    private String roomId;

}