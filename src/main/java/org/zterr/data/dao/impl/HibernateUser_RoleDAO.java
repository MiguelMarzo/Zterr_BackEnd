package org.zterr.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.zterr.backend.data.HibernateSession;
import org.zterr.data.dao.User_RoleDAO;
import org.zterr.data.model.User_Role;

public class HibernateUser_RoleDAO implements User_RoleDAO {

	public User_Role selectById(Integer id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		User_Role user_role = (User_Role) session.get(User_Role.class, id);
		session.close();
		return user_role;
	}

	/*
	 * retrieves all users from db
	 * 
	 * @return List of users
	 */
	public List<User_Role> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<User_Role> users_roles = session.createCriteria(User_Role.class).list();
		session.close();
		return users_roles;
	}

	/*
	 * inserts a new user in database retrieves generated id and sets to
	 * user instance
	 * 
	 * @param new user
	 */
	public void insert(User_Role user_role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(user_role);
		user_role.setIdUser(user_role.getIdUser());
		user_role.setIdRole(user_role.getIdRole());
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates user
	 * 
	 * @param user to update
	 */
	public void update(User_Role user_role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(user_role);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * delete given user
	 * 
	 * @param user to delete
	 */
	public void delete(User_Role user_role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user_role);
		session.getTransaction().commit();
		session.close();
	}
}