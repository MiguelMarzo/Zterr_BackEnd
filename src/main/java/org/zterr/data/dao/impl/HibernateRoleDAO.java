package org.zterr.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.zterr.backend.data.HibernateSession;
import org.zterr.data.dao.RoleDAO;
import org.zterr.data.model.Role;

/**
 * Hibernate specific Customer DAO
 * 
 * @author Sergio Martínez
 *
 */
public class HibernateRoleDAO implements RoleDAO {
	/*
	 * selects one customer by Id
	 * 
	 * @param id
	 * 
	 * @return Customer
	 */
	public Role selectById(Integer id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Role role = (Role) session.get(Role.class, id);
		session.close();
		return role;
	}

	/*
	 * retrieves all customers from db
	 * 
	 * @return List of customers
	 */
	public List<Role> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Role> role = session.createCriteria(Role.class).list();
		session.close();
		return role;
	}

	/*
	 * inserts a new customer in database retrieves generated id and sets to
	 * customer instance
	 * 
	 * @param new customer
	 */
	public void insert(Role role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(role);
		role.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates customer
	 * 
	 * @param customer to update
	 */
	public void update(Role role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(role);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * delete given customer
	 * 
	 * @param customer to delete
	 */
	public void delete(Role role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(role);
		session.getTransaction().commit();
		session.close();
	}

}
