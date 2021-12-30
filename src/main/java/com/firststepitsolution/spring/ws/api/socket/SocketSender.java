package com.firststepitsolution.spring.ws.api.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.firststepitsolution.spring.ws.api.DTO.OutputNotificationMessageDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SocketSender {

	private final SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	public SocketSender(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;

	}

	public void sendToWeb(OutputNotificationMessageDTO outputNotificationMessageDTO, Long id) {
		log.info("Sending data to user are {} and message going to id is {}", outputNotificationMessageDTO.toString(),
				id);
		simpMessagingTemplate.convertAndSendToUser(id.toString(), "/queue/notification", outputNotificationMessageDTO);
	}
}
