package br.com.t4k.user.repository;

import br.com.t4k.user.entity.User;

public interface UserRepository {
	public User createUser(Long idFamily, User user);
	public void createUserRole(User user, String authority);
	public User findUserByEmail(User user);
}
