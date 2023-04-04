package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<User> index() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public User show(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void update(User updatedUser, int id) {

        User userToBeUpdated = em.find(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(em.find(User.class, id));
    }
}
