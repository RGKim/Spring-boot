package com.eightlegged.ksy.user.repository;

import com.eightlegged.ksy.user.entity.User;

public interface UserRepository {
	public User createUser(Long idFamily, User user);
	public void createUserRole(User user, String authority);
	public User findUserByEmail(User user);
}
