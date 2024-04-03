package app.service;

import app.dao.UserDao;
import app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private UserDao dao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") UserDao dao) {
        this.dao = dao;
    }


    @Override
    @Transactional
    public void create(User user) {
        dao.create(user);
    }

    @Override
    public User read(Long id) {
         return dao.read(id);
    }


    @Override
    @Transactional
    public void update(User user) {
        dao.update(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
}
