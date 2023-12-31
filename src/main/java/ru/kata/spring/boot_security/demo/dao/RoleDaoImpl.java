package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {


    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Role> allRoles() {
        return entityManager.createQuery("select role from Role role", Role.class).getResultList();
    }


}
