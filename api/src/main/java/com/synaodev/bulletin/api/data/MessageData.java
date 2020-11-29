package com.synaodev.bulletin.api.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.synaodev.bulletin.api.models.MessageModel;

public class MessageData {
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
	static public MessageData generate(MessageModel model) {
		MessageData result = new MessageData();
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
	static public List<MessageData> generate(List<MessageModel> models) {
		List<MessageData> result = new ArrayList<MessageData>();
		for (MessageModel m : models) {
			result.add(MessageData.generate(m));
		}
		return result;
	}
}
