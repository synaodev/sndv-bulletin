package com.synaodev.bulletin.api.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 4, max = 80)
	private String handle;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min = 8)
	private String password;
	@NotBlank
	@Size(min = 2, max = 80)
	private String firstName;
	@NotBlank
	@Size(min = 2, max = 80)
	private String lastName;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<MessageModel> messages = new HashSet<MessageModel>();
	public UserModel() {

	}
	public UserModel(String handle, String email, String password, String firstName, String lastName) {
		this.handle = handle;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean addMessage(MessageModel message) {
		return messages.add(message);
	}
	public Long getId() {
		return id;
	}
	public String getHandle() {
		return handle;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Set<MessageModel> getMessages() {
		return messages;
	}
	public boolean isNew() {
		return id == null;
	}
}
