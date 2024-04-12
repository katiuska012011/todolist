package com.kgonzalez.todolist.services;

import com.kgonzalez.todolist.models.Task;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;

import javax.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;


@SessionScoped
public class TaskService implements ITask, Serializable {
   /* @Inject
    private JPAUtils util;*/
    @PersistenceContext
    EntityManager em ;

    public TaskService(){}
/*    public TaskService (EntityManager em){
        this.em = JPAUtils.getEntityManager();
    }*/

    @Override
    @Transactional
    public void add(Task task) {
        em.persist(task);
    }

    @Override
    public Task getById(Long id) {
        return em.createQuery("SELECT t FROM Task t WHERE t.id =:id", Task.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Task> getAll() {
        return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        String query = "DELETE FROM Task t WHERE t.id = :id";
        em.createQuery(query).setParameter("id", id).executeUpdate();
    }
}
