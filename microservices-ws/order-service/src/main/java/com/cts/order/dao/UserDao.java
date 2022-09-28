package com.cts.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.order.entity.UserInfo;

public interface UserDao extends JpaRepository<UserInfo, String>{
	
}
