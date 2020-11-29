package com.synaodev.bulletin.api.repositories;

import java.util.List;

import com.synaodev.bulletin.api.models.MessageModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<MessageModel, Long> {
	public List<MessageModel> findAll();
}
