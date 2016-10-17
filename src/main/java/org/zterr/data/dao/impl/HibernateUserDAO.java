package org.zterr.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.zterr.backend.data.HibernateSession;
import org.zterr.data.dao.UserDAO;
import org.zterr.data.model.User;

public class HibernateUserDAO implements UserDAO {
	/*
	 * selects one user by Id
	 * 
	 * @param id
	 * 
	 * @return User
	 */
	public User selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

	/*
	 * retrieves all users from db
	 * 
	 * @return List of users
	 */
	public List<User> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<User> users = session.createCriteria(User.class).list();
		session.close();
		return users;
	}

	/*
	 * inserts a new user in database retrieves generated id and sets to
	 * user instance
	 * 
	 * @param new user
	 */
	public void insert(User user) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(user);
		user.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates user
	 * 
	 * @param user to update
	 */
	public void update(User user) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(user);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * delete given user
	 * 
	 * @param user to delete
	 */
	public void delete(User user) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	public User selectById(Integer id) {
		
		return null;
	}
}
