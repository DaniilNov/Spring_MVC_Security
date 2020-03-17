package mvc_hiber.dao;

import mvc_hiber.model.Role;
import mvc_hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addUser(User user) {
//        sessionFactory.getCurrentSession().save(user);
       Session session = sessionFactory.getCurrentSession();
       User userFromDB = roleDao.getUserByName(user.getUsername());
     if (userFromDB==null){
         user.setRoles(Collections.singleton(new Role(1L,"ROLE_USER")));
         session.save(user);
     }
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void removeUser(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        if (user != null) {
            session.delete(user);
        }
    }

    @Override
    public User getUserById(Long id) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> listUsers() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("From User");
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();


        return userList;
    }
}
