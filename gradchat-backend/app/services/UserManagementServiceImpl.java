package services;

import com.avaje.ebean.Ebean;
import com.google.inject.Inject;
import dao.UserDao;
import dto.UserDto;
import models.UserModel;
import play.libs.Json;

/**
 * Created by sameerap on 22/05/2017.
 */
public class UserManagementServiceImpl implements UserManagementService {
    @Inject
    UserDao userDao;

    @Override
    public void createUser(UserDto userDto) {
        Ebean.beginTransaction();
        UserModel userModel = new UserModel();
        userModel.setUserFirstName(userDto.getUserFirstName());
        userModel.setUserLastName(userDto.getUserLastName());
        userModel.setUserEmail(userDto.getUserEmail());
        userModel.setUserPassword(userDto.getUserEmail());

        userModel = userDao.add(userModel);
//        System.out.println(Json.toJson(userModel));
        Ebean.endTransaction();
    }
}
