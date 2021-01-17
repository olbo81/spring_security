package com.boleg.crud_pro.dao;

import com.boleg.crud_pro.entity.Role;

import java.util.List;

public interface RoleDAO {
    public List<Role> getAllRoles();

    public void saveRole(Role role);

    public void deleteRoleById(int id);

    public Role getRoleById(int id);

    public Role getByRoleName(String roleName);
}
