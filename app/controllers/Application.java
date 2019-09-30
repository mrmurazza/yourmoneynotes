package controllers;

import java.util.Map;
import javax.inject.Singleton;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import static utils.ResponseUtil.createSingleEntryMap;

@Singleton
public class Application extends Controller {

    public Result healthCheck() {
        Map<String, String> response = createSingleEntryMap("message", "Hello there asd");
        return ok(Json.toJson(response));
    }
}
