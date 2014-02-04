package com.vaannila.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.User;

public class UserDAOImpl implements UserDAO {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	@Override
	public long saveOrUpdateUser(User user) {
		try {
			System.out.println(user.getDateofbirth());
			session.saveOrUpdate(user);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return user.getId();
	}

	/**
	 * Used to delete a user.
	 */
	@Override
	public void deleteUser(Long userId) {
		try {
			User user = (User) session.get(User.class, userId);
			session.delete(user);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		List<User> courses = null;
		try {
			courses = session.createQuery("from User").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public User listUserById(Long userId) {
		User user = null;
		try {
			user = (User) session.get(User.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User selectUser(User user) {
		System.out.println("user input:"+user.getName());
		/*List users = getHibernateTemplate().findByNamedParam(
                "select u from User as u where u.username=:username and u.password=:password", new String[]
                { "username", "password" }, new Object[]
                { username, password });*/
		List result = session.createQuery("select u from User as u where u.name='"+user.getName()+"'")  
		          //.setParameter("userName","'"+user.getName()+"'")  
		          .list();  
		if (result.size() == 1)
        {
            return (User) result.get(0);
        }
        return null;
	}
}
