package com.synaodev.bulletin.api.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.synaodev.bulletin.api.validators.PasswordsEqual;
import com.synaodev.bulletin.api.validators.UniqueEmail;
import com.synaodev.bulletin.api.validators.UniqueHandle;

@PasswordsEqual
public class RegisterForm {
	@NotBlank(message = "Handle is mandatory")
	@Size(min = 4, max = 80, message = "Handle must be between 4 and 80 characters in length")
	@UniqueHandle
	private String handle;
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Invalid email address")
	@UniqueEmail
	private String email;
	@NotBlank(message = "Password is mandatory")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	private String password;
	@NotBlank(message = "Password confirmation is mandatory")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	private String passwordConfirmation;
	@NotBlank(message = "First name is mandatory")
	@Size(min = 2, max = 80, message = "First name must be between 2 and 80 characters in length")
	private String firstName;
	@NotBlank(message = "Last name is mandatory")
	@Size(min = 2, max = 80, message = "First name must be between 2 and 80 characters in length")
	private String lastName;
	public RegisterForm() {

	}
	public RegisterForm(String handle, String email, String password, String passwordConfirmation, String firstName, String lastName) {
		this.handle = handle;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.firstName = firstName;
		this.lastName = lastName;
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
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
}
