package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;



import javax.persistence.*;


import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

 @PersistenceContext
 private EntityManager entityManager;

 @Override

 public List<User> getUserList() {
  return entityManager.createQuery("from User", User.class).getResultList();
 }

 @Override

 public User getNameUser(String username) {
  Query query = entityManager.createQuery
          ("select u from User u left join fetch u.roles where u.name=:name", User.class);
  query.setParameter("name", username);
  return (User) query.getSingleResult();
 }

 @Override
 public void saveUser(User user) {
  entityManager.persist(user);
 }

 @Override
 public User getUser(Long id) {
  return entityManager.find(User.class, id);
 }

 @Override
 public void updateUser(User user) {
  entityManager.merge(user);
 }

 @Override
 public void deleteUser(Long id) {
  entityManager.remove(getUser(id));
 }


}





