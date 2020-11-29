package com.synaodev.bulletin.api.dtos;

import java.util.ArrayList;
import java.util.List;

import com.synaodev.bulletin.api.models.UserModel;

public class UserDTO {
	private long id;
	private String handle;
	private String email;
	private String firstName;
	private String lastName;
	private int messageCount;
	public long getId() {
		return id;
	}
	public String getHandle() {
		return handle;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getMessageCount() {
		return messageCount;
	}
	static public UserDTO generate(UserModel model) {
		UserDTO result = new UserDTO();
		if (!model.isNew()) {
			result.id = model.getId().longValue();
			result.handle = model.getHandle();
			result.email = model.getEmail();
			result.firstName = model.getFirstName();
			result.lastName = model.getLastName();
			result.messageCount = model.getMessages().size();
		}
		return result;
	}
	static public List<UserDTO> generate(List<UserModel> models) {
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (UserModel m : models) {
			result.add(UserDTO.generate(m));
		}
		return result;
	}
}
