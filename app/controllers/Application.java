package controllers;

import javax.inject.Singleton;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import static lib.ResponseUtil.createSingleEntryMap;

@Singleton
public class Application extends Controller {

    public Result healthCheck() {
        return ok(Json.toJson(createSingleEntryMap("message", "Hello there")));
    }
}
