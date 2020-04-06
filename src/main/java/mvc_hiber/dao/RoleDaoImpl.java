package mvc_hiber.dao;

import mvc_hiber.model.Role;
import mvc_hiber.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByUsername(String username) {
        User user = null;
       Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE username =:username");
        query.setParameter("username", username);
        user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public Role getRoleById(Long id) {
        return sessionFactory.getCurrentSession().get(Role.class,id);
    }

//    public Role getRoleByUserId(Long id){
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createNativeQuery("select roles_id from users_role where users_id =id;");
//
//    }
}
