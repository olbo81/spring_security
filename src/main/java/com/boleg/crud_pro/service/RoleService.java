package com.boleg.crud_pro.service;

import com.boleg.crud_pro.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles();

    public void saveRole(Role role);

    public void deleteRoleById(int id);

    public Role getRoleById(int id);

    public Role getByRoleName(String roleName);
}
