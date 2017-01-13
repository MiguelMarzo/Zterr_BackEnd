package org.zterr.backend.data;

import java.util.List;


import org.zterr.data.dao.UserDAO;
import org.zterr.data.dao.impl.HibernateUserDAO;
import org.zterr.data.model.User;

public class Main {

	public static void showAll(UserDAO userDAO) {
		// SELECT ALL DATA
				List<User> users = userDAO.selectAll(User.class);
				System.out.println("--- USER ----- table contents	-----------");
				for (User user : users) {
					System.out.println("Id: " + user.getId());
					System.out.println(" - Name: " + user.getUsername());
					System.out.println(" - Address: " + user.getPassword());
				}
				System.out.println("Total users: " + users.size());
	}

	public static void main(String[] args) {
		UserDAO userDAO = new HibernateUserDAO();
		showAll(userDAO);
	}
}
