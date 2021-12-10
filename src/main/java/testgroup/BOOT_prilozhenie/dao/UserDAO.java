package testgroup.BOOT_prilozhenie.dao;

import testgroup.BOOT_prilozhenie.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    void add(User user);

    void delete(User user);

    void edit(User user);

    User getById(int id);

    User findByUsername(String username);
}
