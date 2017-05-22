package controllers;

import com.google.inject.Inject;
import dto.UserDto;
import play.libs.Json;
import play.mvc.*;

import services.UserManagementService;
import utilities.JsonMapper;
import views.html.*;

import java.io.IOException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {

    @Inject
    private UserManagementService userManagementService;

//    @Inject
//    public LoginController(UserManagementService userManagementService) {
//        this.userManagementService = userManagementService;
//    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result createUser(){
        UserDto userDto = null;
        String requestParams = request().body().asJson().toString();
//        System.out.println(requestParams);
        try {
            userDto = JsonMapper.mapJson(requestParams, UserDto.class);
            userManagementService.createUser(userDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok(Json.toJson(userDto));
    }

    public Result index() {
        return ok("Your new application is ready.");
    }

}
