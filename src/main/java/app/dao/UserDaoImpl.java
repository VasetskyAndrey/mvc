package app.dao;

import app.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager eM;

    @Override
    public void create(User user) {
        eM.persist(user);
    }

    @Override
    public User read(Long id) {
       return eM.find(User.class, id);
    }

    @Override
    public void update(User user) {
        eM.merge(user);
    }

    @Override
    public void delete(Long id) {
        eM.createQuery("delete from User where id =: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        return eM.createQuery("from User order by id", User.class).getResultList();
    }
}
