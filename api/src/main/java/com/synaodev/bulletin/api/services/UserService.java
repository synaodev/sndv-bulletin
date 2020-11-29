package com.synaodev.bulletin.api.services;

import java.util.List;
import java.util.Optional;

import com.synaodev.bulletin.api.models.UserModel;
import com.synaodev.bulletin.api.repositories.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository repository;
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	public List<UserModel> findAll() {
		return repository.findAll();
	}
	public UserModel findByHandle(String handle) {
		if (!repository.existsByHandle(handle)) {
			return null;
		}
		List<UserModel> users = repository.findByHandle(handle);
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
	public UserModel findByEmail(String email) {
		if (!repository.existsByEmail(email)) {
			return null;
		}
		List<UserModel> users = repository.findByEmail(email);
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
	public UserModel read(Long id) {
		Optional<UserModel> optional = repository.findById(id);
		if (!optional.isPresent()) {
			return null;
		}
		return optional.get();
	}
	public UserModel create(UserModel user) {
		Long id = user.getId();
		if (repository.existsById(id)) {
			Optional<UserModel> optional = repository.findById(id);
			if (!optional.isPresent()) {
				return null;
			}
			return optional.get();
		}
		return repository.save(user);
	}
	public UserModel update(UserModel user) {
		Long id = user.getId();
		if (!repository.existsById(id)) {
			return user;
		}
		return repository.save(user);
	}
	public boolean delete(Long id) {
		if (!repository.existsById(id)) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
