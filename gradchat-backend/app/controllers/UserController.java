package controllers;

import com.google.inject.Inject;
import dto.UserDto;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserManagementService;

import java.util.List;

public class UserController extends Controller {
    @Inject
    private UserManagementService userManagementService;
    public Result getAllUsers(){
        List<UserDto> userDetailsList = userManagementService.getAllUsers();

        if (userDetailsList != null && !userDetailsList.isEmpty()) {
            return ok(Json.toJson(userDetailsList));
        }
        return ok("Error In Retrieving User List");
    }

    public Result getUserByID(Long id){
        UserDto user = userManagementService.getUserByID(id);

        if (user != null ) {
            return ok(Json.toJson(user));
        }
        return notFound("Error In Retrieving User List");
    }
}
