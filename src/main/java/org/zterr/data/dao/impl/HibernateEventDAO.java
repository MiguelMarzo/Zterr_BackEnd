package org.zterr.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.zterr.backend.data.HibernateSession;
import org.zterr.data.dao.EventDAO;
import org.zterr.data.model.Event;

public class HibernateEventDAO implements EventDAO {
	/*
	 * selects one event by Id
	 * 
	 * @param id
	 * 
	 * @return Events
	 */
	public Event selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Event event = (Event) session.get(Event.class, id);
		session.close();
		return event;
	}

	/*
	 * retrieves all events from db
	 * 
	 * @return List of events
	 */
	public List<Event> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Event> events = session.createCriteria(Event.class).list();
		session.close();
		return events;
	}

	/*
	 * inserts a new event in database retrieves generated id and sets to
	 * event instance
	 * 
	 * @param new event
	 */
	public void insert(Event event) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(event);
		event.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates event
	 * 
	 * @param event to update
	 */
	public void update(Event event) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(event);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * delete given event
	 * 
	 * @param event to delete
	 */
	public void delete(Event event) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(event);
		session.getTransaction().commit();
		session.close();
	}

	public Event selectById(Integer id) {
		
		return null;
	}
}
