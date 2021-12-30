package com.firststepitsolution.spring.ws.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firststepitsolution.spring.ws.api.DTO.MessageSendToUserDTO;
import com.firststepitsolution.spring.ws.api.DTO.OutputNotificationMessageDTO;
import com.firststepitsolution.spring.ws.api.socket.SocketSender;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SendToUserController {

	@Autowired
	private SocketSender socketSender;

	@PostMapping("/send/{id}")
	public ResponseEntity<Object> register(@PathVariable("id") Long id,
			@RequestBody MessageSendToUserDTO messageSendToUserDTO) {
		log.info("Request data are {}", messageSendToUserDTO.toString());
		OutputNotificationMessageDTO outputNotificationMessageDTO = new OutputNotificationMessageDTO();
		outputNotificationMessageDTO.setId(id);
		outputNotificationMessageDTO.setTitle(messageSendToUserDTO.getTitle());
		outputNotificationMessageDTO.setMessage(messageSendToUserDTO.getMessage());
		socketSender.sendToWeb(outputNotificationMessageDTO, id);
		return ResponseEntity.ok().build();
	}
}
