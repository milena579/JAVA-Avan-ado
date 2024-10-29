package com.desktopapp;

import java.util.*;

import com.desktopapp.model.MensagemData;
import com.desktopapp.model.UserData;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Context {
    private EntityManagerFactory emf;
    private EntityManager em;

    public Context() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void begin() {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            em = null;
        }
    }

    public <T> TypedQuery<T> createQuery(Class<T> entityClass, String query){
        EntityManager em = emf.createEntityManager();
        return em.createQuery(query, entityClass);
    }

    public <T> List<T> find(Class<T> entytyClass, String query, Object... values) {
        EntityManager em = emf.createEntityManager();
        List<T> users = null;
        try {
            var queryObj = em.createQuery(query, entytyClass);
            for (Integer i = 0; i < values.length; i++) {
                queryObj = queryObj.setParameter("arg" + i.toString(), values[i]);
            }
            users = queryObj.getResultList();
        } finally {
            em.close();
        }

        return users;
    }

    public <T> List<T> findAll(Class<T> entytyClass) {
        EntityManager em = emf.createEntityManager();
        List<T> user = null;
        try {
            var queryObj = em.createQuery("select p from ProdutoData p", entytyClass);
            user = queryObj.getResultList();
        } finally {
            em.close();
        }
        return user;
    }

    public <T> T find(Class<T> entityClass, Object primaryKey) {
        EntityManager em = emf.createEntityManager();
        T user = null;
        try {
            user = em.find(entityClass, primaryKey);
        } finally {
            em.close();
        }
        return user;
    }

    public void save(Object object) {
        if (em == null) {
            System.out.println("connection is null.");
            return;
        }
        try {
            em.persist(object);
        }
        catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            em = null;
        }
    }

    public void commit() {
        if (em == null) {
            System.out.println("connection is null.");
            return; 
        }
        try {
            em.getTransaction().commit();
        } 
        catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
            em = null;
        }
    }

    public void persist(UserData user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'persist'");
    }

    public void persist(MensagemData mensagem){
        if (em == null) {
            System.out.println("connection is null.");
            return;
        }
        try {
            em.persist(mensagem);
        }
        catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            em = null;
        }
    }

    public void update(Object object){
        if (em == null) {
            System.out.println("connection is null.");
            return;
        }
        try {
           em.merge(object);
        }
        catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            em = null;
        }
    }


    public void delete(Object object){
        if (em == null) {
            System.out.println("connection is null.");
            return;
        }
        try {
            em.remove(em.contains(object) ? object : em.merge(object));
        }
        catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            em = null;
        }
    }

}
