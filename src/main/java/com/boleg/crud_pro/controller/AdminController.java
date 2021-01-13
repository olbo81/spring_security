package com.boleg.crud_pro.controller;

import com.boleg.crud_pro.entity.Role;
import com.boleg.crud_pro.entity.User;
import com.boleg.crud_pro.service.RoleService;
import com.boleg.crud_pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String user(Principal principal, Model model) {
        String email = principal.getName();
        User admin = userService.getByEmail(email);
        model.addAttribute("admin", admin);
        model.addAttribute("roles", admin.getRoles());
        return "all-users";
    }

    @RequestMapping("/all-users")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("rolesNames", roleService.getAllRoles());
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam(value = "rolesNames") String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String roleName : roles) {
            roleSet.add(roleService.getByRoleName(roleName));
        }
        user.setRoles(roleSet);
        userService.saveUser(user);
        return "redirect:/admin/all-users";
    }

    @RequestMapping("/updateInfo/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("rolesNames", roleService.getAllRoles());
        model.addAttribute("user", userService.getUser(id));
        return "user-info";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin/all-users";
    }
}
