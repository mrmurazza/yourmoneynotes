package services.api;

import com.google.inject.ImplementedBy;

import java.util.Optional;

import entity.dao.User;
import entity.exceptions.ListException;
import entity.request.UserSignupRequest;
import services.user.UserManagerImpl;

@ImplementedBy(UserManagerImpl.class)
public interface UserManager {

  Optional<User> getCurrentUser();

  Optional<User> login(String email, String password);

  User signup(UserSignupRequest request) throws ListException;

}
