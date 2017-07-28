package br.com.t4k.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.t4k.user.entity.Role;
import br.com.t4k.user.entity.User;
import br.com.t4k.user.entity.mapper.UserRowMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(rollbackFor=java.sql.SQLException.class)
	public User createUser(Long idFamily, User user) {

		if(idFamily == 0){
			return createUserMaster(user);
		}
		return createUserMember(idFamily, user);
	}
	
	private User createUserMaster(User user){
		String sql = "INSERT INTO USER (ID, EMAIL, NAME, LAST_NAME, PASSWORD, ID_FAMILY, NAME_FAMILY) VALUES (?, ?, ?, ?, ?, ?, ?)";
		user.setId(nextvalUserSequence());
		user.setIdFamily(user.getId());
		jdbcTemplate.update(sql, new Object[] { user.getId(), user.getEmail(), user.getName(), 
												user.getLastName(), user.getPass(), user.getIdFamily(), user.getNameFamily()});
		createUserRole(user, Role.MASTER.authority());
		return user;
	}
	
	private User createUserMember(Long idFamily, User user){
		String sql = "INSERT INTO USER (ID, EMAIL, NAME, LAST_NAME, PASSWORD, ID_FAMILY, NAME_FAMILY) VALUES (?, ?, ?, ?, ?, ?, ?)";
		user.setId(nextvalUserSequence());
		user.setIdFamily(idFamily);
		jdbcTemplate.update(sql, new Object[] { user.getId(), user.getEmail(), user.getName(), 
												user.getLastName(), user.getPass(), user.getIdFamily(), user.getNameFamily()});
		createUserRole(user, Role.MEMBER.authority());
		return user;
	}

	@Override
	public User findUserByEmail(User user) {
		try{
			String sql = "SELECT * FROM USER WHERE EMAIL=?";
			user = jdbcTemplate.queryForObject(sql, new Object[] { user.getEmail() }, new UserRowMapper());
			return user;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void createUserRole(User user, String authority) {
		 String sql = "INSERT INTO USER_ROLE (ID, ROLE, USER_ID) VALUES(USER_ROLE_SEQ.NEXTVAL, ?,?)";
		 jdbcTemplate.update(sql, new Object[] {authority, user.getId()});
	}
	
	private Long nextvalUserSequence() {
		String sqlSequence = "SELECT USER_SEQ.NEXTVAL"; 
		return jdbcTemplate.queryForObject(sqlSequence, Long.class);
	}

}
