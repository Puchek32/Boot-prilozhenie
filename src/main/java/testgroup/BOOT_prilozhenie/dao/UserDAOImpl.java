package testgroup.BOOT_prilozhenie.dao;

import org.springframework.stereotype.Repository;
import testgroup.BOOT_prilozhenie.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> allUsers() {
        return manager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public void delete(User user) {
        manager.remove(manager.find(User.class, user.getId()));
    }

    @Override
    public void edit(User user) {
        manager.merge(user);
    }

    @Override
    public User getById(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        return manager
                .createQuery("from User where user_name = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }
}