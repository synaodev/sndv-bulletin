package com.synaodev.bulletin.api.controllers;

import java.util.List;

import com.synaodev.bulletin.api.dtos.MessageDTO;
import com.synaodev.bulletin.api.models.MessageModel;
import com.synaodev.bulletin.api.services.MessageService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	private final MessageService messageService;
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	@GetMapping("/api/message/all")
	public List<MessageDTO> getAll() {
		List<MessageModel> models = messageService.findAll();
		return MessageDTO.generate(models);
	}
	@GetMapping("/api/message/id/{id}")
	public MessageDTO getById(@PathVariable Long id) {
		MessageModel model = messageService.read(id);
		if (model != null) {
			return MessageDTO.generate(model);
		}
		return null;
	}
}
