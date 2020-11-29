package com.synaodev.bulletin.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.synaodev.bulletin.api.data.MessageData;
import com.synaodev.bulletin.api.forms.MessageForm;
import com.synaodev.bulletin.api.models.MessageModel;
import com.synaodev.bulletin.api.models.UserModel;
import com.synaodev.bulletin.api.services.MessageService;
import com.synaodev.bulletin.api.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	private final MessageService messageService;
	private final UserService userService;
	public MessageController(MessageService messageService, UserService userService) {
		this.messageService = messageService;
		this.userService = userService;
	}
	@GetMapping("/api/message/all")
	public List<MessageData> getAll() {
		List<MessageModel> models = messageService.findAll();
		return MessageData.generate(models);
	}
	@GetMapping("/api/message/id/{id}")
	public MessageData getById(@PathVariable Long id) {
		MessageModel model = messageService.read(id);
		if (model != null) {
			return MessageData.generate(model);
		}
		return null;
	}
	@PostMapping("/api/message")
	public MessageData create(@Valid @RequestBody MessageForm form) {
		UserModel user = userService.read(form.getUserId());
		if (user == null) {
			return null;
		}
		MessageModel parent = null;
		if (form.isComment()) {
			parent = messageService.read(form.getParentId());
			if (parent == null) {
				return null;
			}
		}
		MessageModel model = new MessageModel(
			form.getContent(),
			user,
			parent
		);
		model = messageService.create(model);
		return MessageData.generate(model);
	}
	@DeleteMapping("/api/message/{id}")
	public boolean remove(@PathVariable Long id) {
		return messageService.delete(id);
	}
}
