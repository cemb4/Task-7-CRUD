package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override

    public List<User> findAllUser() {
        return userDAO.index();
    }

    @Override

    public User findUserById(int id) {
        return userDAO.show(id);
    }

    @Override

    public void saveUserByUser(User user) {
        userDAO.save(user);
    }

    @Override

    public void updateUserByUserAndId(User user, int id) {
        userDAO.update(user, id);
    }

    @Override

    public void deleteUserById(int id) {
        userDAO.delete(id);
    }
}
