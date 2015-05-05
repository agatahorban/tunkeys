/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappdao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 *
 * @author ag
 */
public abstract class AbstractCrudRepository<T extends Object> implements Crudable<T> {

    @Inject
    private SessionFactory sessionFactory;
    private Class<T> domainClass;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }
    
    private String getDomainClassName() {
        return getDomainClass().getName();
    }
    
    @Override
    public void insert(T entity) {
        getSession().save(entity);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T find(Serializable id) {
        return (T) getSession().get(getDomainClass(), id);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return getSession()
                .createQuery("from " + getDomainClassName())
                .list();
    }
    
    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void deleteById(Serializable id) {
        delete(find(id));
    }

    @Override
    public void deleteAll() {
        getSession()
                .createQuery("delete " + getDomainClassName())
                .executeUpdate();
    }
}