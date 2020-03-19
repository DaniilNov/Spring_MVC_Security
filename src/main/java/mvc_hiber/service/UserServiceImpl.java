package mvc_hiber.service;


import mvc_hiber.dao.RoleDao;
import mvc_hiber.dao.UserDao;
import mvc_hiber.model.Role;
import mvc_hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    @Override
    public void addUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getRoleById(1L));
        user.setRoles(roles);
        userDao.addUser(user);
    }


    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }


    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }


    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = roleDao.getUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("User is not found");
        }
        return user;
    }
}



