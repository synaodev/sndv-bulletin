package com.synaodev.bulletin.api.data;

import java.util.ArrayList;
import java.util.List;

import com.synaodev.bulletin.api.models.UserModel;

public class UserData {
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
	static public UserData generate(UserModel model) {
		UserData result = new UserData();
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
	static public List<UserData> generate(List<UserModel> models) {
		List<UserData> result = new ArrayList<UserData>();
		for (UserModel m : models) {
			result.add(UserData.generate(m));
		}
		return result;
	}
}
