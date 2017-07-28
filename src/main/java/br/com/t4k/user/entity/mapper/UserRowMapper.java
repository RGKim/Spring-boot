package br.com.t4k.user.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.t4k.user.entity.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setEmail(rs.getString("EMAIL"));
		user.setName(rs.getString("NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setPass(rs.getString("PASSWORD"));
		return user;
	}

}
