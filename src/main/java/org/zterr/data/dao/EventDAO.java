package org.zterr.data.dao;

import java.util.List;

import org.zterr.data.model.Event;

public interface EventDAO {

	public Event selectById(Integer id);

	public List<Event> selectAll();

	public void insert(Event event);

	public void update(Event event);

	public void delete(Event event);

}
