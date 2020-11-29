package com.synaodev.bulletin.api.services;

import java.util.List;
import java.util.Optional;

import com.synaodev.bulletin.api.models.MessageModel;
import com.synaodev.bulletin.api.repositories.MessageRepository;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	private final MessageRepository repository;
	public MessageService(MessageRepository repository) {
		this.repository = repository;
	}
	public List<MessageModel> findAll() {
		return repository.findAll();
	}
	public MessageModel read(Long id) {
		Optional<MessageModel> optional = repository.findById(id);
		if (!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	public MessageModel create(MessageModel message) {
		Long id = message.getId();
		if (repository.existsById(id)) {
			Optional<MessageModel> optional = repository.findById(id);
			if (!optional.isPresent()) {
				return null;
			}
			return optional.get();
		}
		return repository.save(message);
	}
	public MessageModel update(MessageModel message) {
		Long id = message.getId();
		if (!repository.existsById(id)) {
			return message;
		}
		return repository.save(message);
	}
	public boolean delete(Long id) {
		if (!repository.existsById(id)) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
