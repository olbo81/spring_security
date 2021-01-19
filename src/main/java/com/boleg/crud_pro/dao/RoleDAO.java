package com.boleg.crud_pro.dao;

import com.boleg.crud_pro.entity.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getAllRoles();

    void saveRole(Role role);

    void deleteRoleById(Long id);

    Role getRoleById(Long id);

    Role getByRoleName(String roleName);
}
