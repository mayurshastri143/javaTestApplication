package com.vaannila.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.Council;
import com.vaannila.domain.User;

public class CouncilImpl implements CouncilDAO {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	@Override
	public void saveOrUpdateCouncil(Council council) {
		try {
			session.saveOrUpdate(council);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Council> listCouncil() {
		List<Council> result=null;
		try {
			result=session.createQuery("from Council").list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Council listCouncilById(int id) {
		Council council= null;
		try {
			council = (Council) session.get(Council.class,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return council;
	}

	@Override
	public void deleteCouncil(int id) {
		try {
			Council council= (Council) session.get(Council.class, id);
			session.delete(council);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Council selectCouncil(String councilName) {
		System.out.println("user input:"+councilName);
		List result = session.createQuery("select c from Council as c where c.councilName='"+councilName+"'").list();  
		if (result.size() == 1){
            return (Council) result.get(0);
        }
        return null;
	}
}
