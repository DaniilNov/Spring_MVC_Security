package mvc_hiber.dao;

import mvc_hiber.model.Role;
import mvc_hiber.model.User;

public interface RoleDao {
    User getUserByUsername(String username);
    Role getRoleById(Long id);


}
