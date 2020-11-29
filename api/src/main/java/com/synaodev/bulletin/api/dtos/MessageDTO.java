package com.synaodev.bulletin.api.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.synaodev.bulletin.api.models.MessageModel;

public class MessageDTO {
	private long id;
	private String content;
	private long userId;
	private long parentId;
	private int childrenCount;
	private Date createdAt;
	private Date updatedAt;
	public long getId() {
		return id;
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
	public int getChildrenCount() {
		return childrenCount;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	static public MessageDTO generate(MessageModel model) {
		MessageDTO result = new MessageDTO();
		if (!model.isNew()) {
			result.id = model.getId().longValue();
			result.content = model.getContent();
			result.userId = model.getUser().getId().longValue();
			if (!model.isAlone()) {
				result.parentId = model.getParent().getId().longValue();
			}
			result.childrenCount = model.getChildren().size();
			result.createdAt = model.getCreatedAt();
			result.updatedAt = model.getUpdatedAt();
		}
		return result;
	}
	static public List<MessageDTO> generate(List<MessageModel> models) {
		List<MessageDTO> result = new ArrayList<MessageDTO>();
		for (MessageModel m : models) {
			result.add(MessageDTO.generate(m));
		}
		return result;
	}
}
