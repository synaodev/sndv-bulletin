package com.synaodev.bulletin.api.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "messages")
public class MessageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Message must have content")
	@Size(max = 500, message = "Message must less than 500 characters")
	private String content;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id", nullable = true)
	private MessageModel parent;
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private Set<MessageModel> children = new HashSet<MessageModel>();
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	public MessageModel() {

	}
	public MessageModel(String content, UserModel user, MessageModel parent) {
		this.content = content;
		this.user = user;
		this.parent = parent;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public void setParent(MessageModel parent) {
		this.parent = parent;
	}
	public boolean addChild(MessageModel child) {
		return children.add(child);
	}
	public Long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public UserModel getUser() {
		return user;
	}
	public MessageModel getParent() {
		return parent;
	}
	public Set<MessageModel> getChildren() {
		return children;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public boolean isNew() {
		return id == null;
	}
	public boolean isAlone() {
		return parent == null;
	}
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
}
