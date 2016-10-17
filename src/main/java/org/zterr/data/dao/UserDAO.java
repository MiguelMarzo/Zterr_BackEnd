package org.zterr.data.dao;

import java.util.List;

import org.zterr.data.model.User;

public interface UserDAO {

	public User selectById(Integer id);

	public List<User> selectAll();

	public void insert(User user);

	public void update(User user);

	public void delete(User user);

}
