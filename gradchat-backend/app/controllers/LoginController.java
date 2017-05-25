package controllers;

import com.google.inject.Inject;
import dao.UserDao;
import dto.UserDto;
import play.libs.Json;
import play.mvc.*;

import services.UserManagementService;
import utilities.JsonMapper;
import views.html.*;

import java.io.IOException;
import java.util.List;

public class LoginController extends Controller {

    @Inject
    private UserManagementService userManagementService;

//    public Result signupScreen() {
//        return ok(signup.render());
//    }
//
//    public Result loginScreen() {
//        return ok(login.render());
//    }


    @BodyParser.Of(BodyParser.Json.class)
    public Result createUser() throws IOException {
        UserDto userDto = null;
        String requestParams = request().body().asJson().toString();
        try {
            userDto = JsonMapper.mapJson(requestParams, UserDto.class);
            userManagementService.createUser(userDto);
        } catch (IOException e) {
            throw new IOException();
        }
        return ok(Json.toJson(userDto));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result authenticate(){
        UserDto userDto = null;
        String requestParams = request().body().asJson().toString();
        try {
            userDto = JsonMapper.mapJson(requestParams, UserDto.class);
            userManagementService.loginUser(userDto);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            userDto.setUserId((long) 0);
        } catch (Exception e) {
            userDto.setUserId((long) 0);
        }
        return ok(Json.toJson(userDto));

    }

//    public Result index() {
//        return ok(index.render());
//    }

}
