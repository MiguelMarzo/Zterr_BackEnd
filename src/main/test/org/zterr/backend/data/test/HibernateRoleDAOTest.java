package org.zterr.backend.data.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zterr.data.dao.RoleDAO;
import org.zterr.data.dao.UserDAO;
import org.zterr.data.dao.impl.HibernateRoleDAO;
import org.zterr.data.dao.impl.HibernateUserDAO;
import org.zterr.data.model.Role;
import org.zterr.data.model.User;

import junit.framework.TestCase;

public class HibernateRoleDAOTest extends TestCase {

	private RoleDAO roleDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		roleDAO = new HibernateRoleDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateRoleDAO#selectById(java.lang.Long)}.
	 */
	@Test
	public void testSelectById() {
		//UserDAO user = new HibernateUserDAO();
		//User user1 = new User();
		// Select after insert
		Role insertRole = new Role(null,"Admin","Administrator role");
		//user1.getRoles().add(insertRole);
		//user.insert(user1);
		roleDAO.insert(insertRole);
		Role role = roleDAO.selectById(insertRole.getId());
		assertEquals("Select by Id should exist",role.getId(), insertRole.getId());
//		
		}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateRoleDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		
		//UserDAO user = new HibernateUserDAO();
		//User user1 = new User();
		
		int totalElements = roleDAO.selectAll().size();
		
		Role insertRole = new Role(null,"Admin","Administrator role");
		//user1.getRoles().add(insertRole);
		//user.insert(user1);
		
		roleDAO.insert(insertRole);
		int totalElementsAfterInsert = roleDAO.selectAll().size();
		
		assertEquals("Select All returns all elements", totalElements + 1, totalElementsAfterInsert);
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateRoleDAO#insert(io.wzw.backend.data.model.Role)}.
	 */
	@Test
	public void testInsert() {
		assertTrue("Insert",true);
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateRoleDAO#update(io.wzw.backend.data.model.Role)}.
	 */
	@Test
	public void testUpdate() {
		//UserDAO user = new HibernateUserDAO();
		//User user1 = new User();
		String updatedName = "Admin changed";
		
		// Select after first insert
		Role insertRole = new Role(null,"Admin","Administrator role");
		//user1.getRoles().add(insertRole);
		//user.insert(user1);
		roleDAO.insert(insertRole);
		
		// We update the role
		insertRole.setName(updatedName);
		roleDAO.update(insertRole);
		
		// Select and check if name has changed
		Role updatedRole = roleDAO.selectById(insertRole.getId());
		
		assertEquals("Role name was changed", updatedName, updatedRole.getName());
	}

	/**
	 * Test method for {@link io.wzw.backend.data.dao.impl.HibernateRoleDAO#delete(io.wzw.backend.data.model.Role)}.
	 */
	@Test
	public void testDelete() {
		// Select after first insert
		//UserDAO user = new HibernateUserDAO();
		//User user1 = new User();
		Role insertRole = new Role(null,"Admin","Administrator role");
		//user1.getRoles().add(insertRole);
		//user.insert(user1);
		roleDAO.insert(insertRole);
		
		// Delete 
		roleDAO.delete(insertRole);
		Role role = roleDAO.selectById(insertRole.getId());
		assertNull("Select by Id with a deleted record id shoud be null",role);	
	}
}
