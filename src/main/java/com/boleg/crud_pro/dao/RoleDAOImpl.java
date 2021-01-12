package com.boleg.crud_pro.dao;

import com.boleg.crud_pro.entity.Role;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        List<Role> allRoles = entityManager.createQuery("from Role", Role.class).getResultList();
        return allRoles;
    }

    @Override
    public void saveRole(Role role) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(role);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public Role getById(int id) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT role FROM Role role WHERE role.id = :id", Role.class);
        return query
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Role getByRoleName(String roleName) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT role FROM Role role WHERE role.role = :roleName", Role.class);
        return query
                .setParameter("roleName", roleName)
                .getSingleResult();
    }
}
