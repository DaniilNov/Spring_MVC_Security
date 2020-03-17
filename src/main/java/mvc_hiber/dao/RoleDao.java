package mvc_hiber.dao;

import mvc_hiber.model.User;

public interface RoleDao {
    User getUserByName(String username);

}
