package com.firststepitsolution.spring.ws.api.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OutputNotificationMessageDTO {

	private Long id;
    private String title;
    private String message;
}
