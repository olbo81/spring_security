package com.boleg.crud_pro.dao;

import com.boleg.crud_pro.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {

//        User user = entityManager.find(User.class, id);
//        return user;

        TypedQuery<User> query = entityManager.createQuery(
                "SELECT users FROM User users WHERE users.id = :id", User.class);
        return query
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getByEmail(String email) {

//        User user = entityManager.find(User.class, email);
//        return user;

        TypedQuery<User> query = entityManager.createQuery(
                "SELECT user FROM User user WHERE user.email = :name", User.class);
        return query
                .setParameter("name", email)
                .getSingleResult();

    }
}

