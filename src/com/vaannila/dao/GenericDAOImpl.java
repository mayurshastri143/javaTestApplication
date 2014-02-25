package com.vaannila.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
 
/**
 *
 * @author leonidas
 */
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
 
    @SessionTarget
    Session session;
    
    @TransactionTarget
    Transaction transaction;
	
    public void save(T entity) {
        session.saveOrUpdate(entity);
    }
 
    public void merge(T entity) {
        session.merge(entity);
    }
 
    public void delete(T entity) {
        session.delete(entity);
    }
 
    public List<T> findMany(Query query) {
        List<T> t;
        t = (List<T>) query.list();
        return t;
    }
 
    public T findOne(Query query) {
        T t;
        t = (T) query.uniqueResult();
        return t;
    }
 
    public T findByID(Class clazz, int id) {
        T t = null;
        t = (T) session.get(clazz, id);
        return t;
    }
 
    public List findAll(Class clazz) {
        List T = null;
        Query query = session.createQuery("from " + clazz.getName());
        T = query.list();
        return T;
    }
}