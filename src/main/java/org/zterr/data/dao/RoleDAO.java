package org.zterr.data.dao;

import java.util.List;

import org.zterr.data.model.Role;

public interface RoleDAO {

	public Role selectById(Integer id);

	public List<Role> selectAll();

	public void insert(Role role);

	public void update(Role role);

	public void delete(Role role);

}
