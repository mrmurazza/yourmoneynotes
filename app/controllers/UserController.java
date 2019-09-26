package controllers;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import entity.dao.User;
import entity.exceptions.ListException;
import entity.request.FormRequest;
import entity.request.JsonRequest;
import entity.request.UserSignupRequest;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.api.UserManager;

import static entity.request.UserSignupRequest.initFromFormRequest;
import static entity.response.BaseJSONResponse.initErrorResponse;
import static entity.response.BaseJSONResponse.initSingleErrorResponse;
import static entity.response.BaseJSONResponse.initSuccessResponse;
import static lib.ResponseUtil.createSingleEntryMap;

@Singleton
public class UserController extends Controller {

    private UserManager userManager;

    @Inject
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @Transactional
    public Result signupPost() {
        UserSignupRequest request = initFromFormRequest(new FormRequest(request()));
        User user;

        try {
            user = userManager.signup(request);
        } catch (ListException e) {
            return badRequest(Json.toJson(initErrorResponse(e.getErrors())));
        }

        return ok(Json.toJson(initSuccessResponse(user)));
    }

    @Transactional
    public Result login() {
        JsonRequest request = new JsonRequest(request());
        String email = request.getOptionalObject("email", String.class).orElse(null);
        String password = request.getOptionalObject("password", String.class).orElse(null);

        Optional<User> user = userManager.login(email, password);

        if (user.isPresent())
            return ok(Json.toJson(initSuccessResponse(createSingleEntryMap("access_token",
                                                                           user.get()
                                                                               .getAccessToken()))));

        return badRequest(Json.toJson(initSingleErrorResponse("Login error, please retry!")));
    }
}
