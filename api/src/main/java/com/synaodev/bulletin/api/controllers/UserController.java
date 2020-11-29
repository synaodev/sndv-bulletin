package com.synaodev.bulletin.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.synaodev.bulletin.api.dtos.UserDTO;
import com.synaodev.bulletin.api.forms.LoginForm;
import com.synaodev.bulletin.api.forms.RegisterForm;
import com.synaodev.bulletin.api.models.UserModel;
import com.synaodev.bulletin.api.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/api/user")
	public List<UserDTO> getAll() {
		List<UserModel> models = userService.findAll();
		return UserDTO.generate(models);
	}
	@GetMapping("/api/user/id/{id}")
	public UserDTO getById(@PathVariable Long id) {
		UserModel model = userService.read(id);
		if (model != null) {
			return UserDTO.generate(model);
		}
		return null;
	}
	@GetMapping("/api/user/handle/{handle}")
	public UserDTO getByHandle(@PathVariable String handle) {
		UserModel model = userService.findByHandle(handle);
		return UserDTO.generate(model);
	}
	@GetMapping("/api/user/email/{email}")
	public UserDTO getByEmail(@PathVariable String email) {
		UserModel model = userService.findByEmail(email);
		return UserDTO.generate(model);
	}
	@PostMapping("/api/user/register")
	public UserDTO register(@Valid @RequestBody RegisterForm form) {
		UserModel model = new UserModel(
			form.getHandle(),
			form.getEmail(),
			form.getPassword(),
			form.getFirstName(),
			form.getLastName()
		);
		model = userService.create(model);
		return UserDTO.generate(model);
	}
	@PostMapping("/api/user/login")
	public UserDTO login(@Valid @RequestBody LoginForm form) {
		UserModel model = userService.findByEmail(form.getEmail());
		if (model == null) {
			return null;
		}
		if (!form.getPassword().equals(model.getPassword())) {
			return null;
		}
		return UserDTO.generate(model);
	}
	@DeleteMapping("/api/user/{id}")
	public boolean remove(@PathVariable Long id) {
		return userService.delete(id);
	}
}
