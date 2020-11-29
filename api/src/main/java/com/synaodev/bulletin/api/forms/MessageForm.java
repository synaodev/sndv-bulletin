package com.synaodev.bulletin.api.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class MessageForm {
	@NotBlank(message = "Message must have content")
	@Size(max = 500, message = "Message must less than 500 characters")
	private String content;
	@Positive(message = "User ID must not be negative or zero")
	private long userId;
	@PositiveOrZero(message = "Parent ID must not be negative")
	private long parentId;
	public MessageForm() {

	}
	public MessageForm(String content, long userId) {
		this.content = content;
		this.userId = userId;
	}
	public MessageForm(String content, long userId, long parentId) {
		this.content = content;
		this.userId = userId;
		this.parentId = parentId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getContent() {
		return content;
	}
	public long getUserId() {
		return userId;
	}
	public long getParentId() {
		return parentId;
	}
	public boolean isComment() {
		return parentId > 0;
	}
}
