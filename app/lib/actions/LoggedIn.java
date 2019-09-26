package lib.actions;

import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import entity.response.BaseJSONResponse;
import entity.dao.User;
import services.user.UserManagerImpl;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class LoggedIn extends Security.Authenticator {
    private UserManagerImpl userManagerImpl;

    @Inject
    public LoggedIn(UserManagerImpl userManagerImpl){
        this.userManagerImpl = userManagerImpl;
    }

    @Override
    public String getUsername(Http.Context ctx) {
        Optional<User> userOpt = userManagerImpl.getCurrentUser();

        return userOpt.map(User::getName).orElse(null);

    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return unauthorized(Json.toJson(BaseJSONResponse.initSingleErrorResponse("ERROR")));
    }

}
