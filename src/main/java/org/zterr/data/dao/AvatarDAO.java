package org.zterr.data.dao;

import java.util.List;

import org.zterr.data.model.Avatar;

public interface AvatarDAO {

	public Avatar selectById(Integer id);

	public List<Avatar> selectAll();

	public void insert(Avatar avatar);

	public void update(Avatar avatar);

	public void delete(Avatar avatar);

}
