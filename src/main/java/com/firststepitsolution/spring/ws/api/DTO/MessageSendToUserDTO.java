package com.firststepitsolution.spring.ws.api.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MessageSendToUserDTO {

    private String title;
    private String message;

}