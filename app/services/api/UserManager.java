package services.api;

import java.util.Optional;

import entity.dao.User;
import entity.exceptions.ListException;
import entity.request.UserSignupRequest;

public interface UserManager {

  Optional<User> getCurrentUser();

  Optional<User> login(String email, String password);

  User signup(UserSignupRequest request) throws ListException;

}
