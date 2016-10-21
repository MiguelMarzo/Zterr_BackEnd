package org.zterr.backend.data;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.wzw.backend.data.dao.RoleDAO;
import io.wzw.backend.data.dao.impl.HibernateRoleDAO;
import io.wzw.backend.data.model.Role;

/**
 * @author MIGUEL MARZO
 *
 */
public class HibernateUserDAOTest {
	private UserDAO userDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userDAO = new HibernateUserDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateUserDAO#selectById(java.lang.Long)}.
	 */
	@Test
	public void testSelectById() {		
		// Select after insert
		User insertUser = new User(null,"Admin","Administrator user");
		UserDAO.insert(insertUser);
		User user = UserDAO.selectById(insertUser.getId());
		assertEquals("Select by Id should exist",User.getId(), insertUser.getId());
		
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateUserDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		int totalElements = UserDAO.selectAll().size();
		
		User insertUser = new User(null,"Admin","Administrator user");
		UserDAO.insert(insertUser);
		int totalElementsAfterInsert = UserDAO.selectAll().size();
		
		assertEquals("Select All returns all elements",totalElements + 1, totalElementsAfterInsert);
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateUserDAO#insert(io.wzw.backend.data.model.Role)}.
	 */
	@Test
	public void testInsert() {
		assertTrue("Insert",true);
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateUserDAO#update(io.wzw.backend.data.model.Role)}.
	 */
	@Test
	public void testUpdate() {
		String updatedName = "Admin changed";
		
		// Select after first insert
		User insertUser = new User(null,"Admin","Administrator user");
		UserDAO.insert(insertUser);
		
		// We update the role
		insertUser.setName(updatedName);
		UserDAO.update(insertUser);
		
		// Select and check if name has changed
		User updatedUser = UserDAO.selectById(insertUser.getId());
		
		assertEquals("Role name was changed", updatedName, updatedUser.getName());
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateRoleDAO#delete(io.wzw.backend.data.model.Role)}.
	 */
	@Test
	public void testDelete() {
		// Select after first insert
		Role insertUser = new User(null,"Admin","Administrator user");
		UserDAO.insert(insertUser);
		
		// Delete 
		userDAO.delete(insertUser);
		User user = userDAO.selectById(insertUser.getId());
		assertNull("Select by Id with a deleted record id shoud be null",user);
		
	}

}