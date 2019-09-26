package dao.api;

import com.google.inject.ImplementedBy;

import java.util.Optional;
import entity.dao.User;
import dao.impl.UserSQL;

@ImplementedBy(UserSQL.class)
public interface UserDAO {
    User persist(User user);
    Optional<User> getByEmail(String email);
    Optional<User> getByEmailAndPassword(String email, String password);
}
