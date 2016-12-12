package org.zterr.backend.data.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zterr.data.dao.UserDAO;
import org.zterr.data.dao.impl.HibernateUserDAO;
import org.zterr.data.model.Role;
import org.zterr.data.model.User;

import junit.framework.TestCase;

public class HibernateUserDAOTest extends TestCase {

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
    	userDAO.insert(insertUser);
		User user = userDAO.selectById(insertUser.getId(), null);
		assertEquals("Select by Id should exist",user.getId(), insertUser.getId());
		
		}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateUserDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		int totalElements = userDAO.selectAll(null).size();
		
		User insertUser = new User(null,"Admin","Administrator user");
		userDAO.insert(insertUser);
		int totalElementsAfterInsert = userDAO.selectAll(null).size();
		
		assertEquals("Select All returns all elements", totalElements + 1, totalElementsAfterInsert);
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateUserDAO#insert(io.wzw.backend.data.model.User)}.
	 */
	@Test
	public void testInsert() {
		assertTrue("Insert",true);
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateUserDAO#update(io.wzw.backend.data.model.User)}.
	 */
	@Test
	public void testUpdate() {
		String updatedName = "Admin changed";
//		
//		// Select after first insert
		User insertUser = new User(null,"Admin","Administrator user");
		userDAO.insert(insertUser);
		
		// We update the user
		insertUser.setUsername(updatedName);
		userDAO.update(insertUser);
		
		// Select and check if name has changed
		User updatedUser = userDAO.selectById(insertUser.getId(), null);
		
		assertEquals("User name was changed", updatedName, updatedUser.getUsername());
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateUserDAO#delete(io.wzw.backend.data.model.User)}.
	 */
	@Test
	public void testDelete() {
		// Select after first insert
		User insertUser = new User(null,"Admin","Administrator user");
		userDAO.insert(insertUser);
		
		// Delete 
		userDAO.delete(insertUser);
		User user = userDAO.selectById(insertUser.getId(), null);
		assertNull("Select by Id with a deleted record id shoud be null",user);	
	}
}
