package org.zterr.data.dao;

import java.util.List;

import org.zterr.data.model.User_Role;

public interface User_RoleDAO {

	public User_Role selectById(Integer id);

	public List<User_Role> selectAll();

	public void insert(User_Role user_role);

	public void update(User_Role user_role);

	public void delete(User_Role user_role);

}
