package com.boleg.crud_pro.service;

import com.boleg.crud_pro.dao.RoleDAO;
import com.boleg.crud_pro.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }


    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    @Transactional
    public void deleteRoleById(int id) {
        roleDAO.deleteRoleById(id);
    }

    @Override
    @Transactional
    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    @Transactional
    public Role getByRoleName(String roleName) {
        return roleDAO.getByRoleName(roleName);
    }
}
