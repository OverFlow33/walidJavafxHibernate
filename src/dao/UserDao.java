package dao;

import modele.User;

public interface UserDao {

    User readById(int id);
    User readByUsername(String username);
    void delete(User user);
    void update(User user);
    void create(User user);

}
