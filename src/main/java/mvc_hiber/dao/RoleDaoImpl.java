package mvc_hiber.dao;

import mvc_hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByName(String username) {
        return sessionFactory.getCurrentSession().get(User.class,username);
    }
}
