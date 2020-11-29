package com.synaodev.bulletin.api.repositories;

import java.util.List;

import com.synaodev.bulletin.api.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
	public List<UserModel> findAll();
	public List<UserModel> findByHandle(String handle);
	public List<UserModel> findByEmail(String email);
	public boolean existsByHandle(String handle);
	public boolean existsByEmail(String email);
}
