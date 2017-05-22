package services;

import com.avaje.ebean.Ebean;
import com.google.inject.Inject;
import dao.UserDao;
import dto.UserDto;
import models.UserModel;
import play.libs.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sameerap on 22/05/2017.
 */
public class UserManagementServiceImpl implements UserManagementService {
    @Inject
    UserDao userDao;

    @Override
    public void createUser(UserDto userDto) {
//        Ebean.beginTransaction();
        UserModel userModel = new UserModel();
        userModel.setUserFirstName(userDto.getUserFirstName());
        userModel.setUserLastName(userDto.getUserLastName());
        userModel.setUserEmail(userDto.getUserEmail());
        userModel.setUserPassword(userDto.getUserPassword());
        System.out.println(Json.toJson(userModel));
        userModel = userDao.add(userModel);

//        Ebean.endTransaction();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserModel> userModelList;

        List<UserDto> userDtoList = new ArrayList<>();
        userModelList = userDao.getAllRecords();
        System.out.println(userModelList.toString());
        for (UserModel userModel : userModelList){
            System.out.println("inside dao");

            UserDto userDto = new UserDto();
            userDto.setUserId(userModel.getUserId());
            userDto.setUserFirstName(userModel.getUserFirstName());
            userDto.setUserLastName(userModel.getUserLastName());
            userDto.setUserEmail(userModel.getUserEmail());
            userDto.setUserPassword(userModel.getUserPassword());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public UserDto findUser(UserDto userDto) {
        UserModel userModel = userDao.getDetailsById(userDto.getUserId());
        userDto.setUserId(userModel.getUserId());
        userDto.setUserFirstName(userModel.getUserFirstName());
        userDto.setUserLastName(userModel.getUserLastName());
        userDto.setUserEmail(userModel.getUserEmail());
        userDto.setUserPassword(userModel.getUserPassword());

        return userDto;
    }

    @Override
    public UserDto loginUser(UserDto userDto) {
        UserModel userModel = userDao.getLoggedInUser(userDto);
        userDto.setUserId(userModel.getUserId());
        userDto.setUserFirstName(userModel.getUserFirstName());
        userDto.setUserLastName(userModel.getUserLastName());
        userDto.setUserEmail(userModel.getUserEmail());
        userDto.setUserPassword(userModel.getUserPassword());

        return userDto;
    }
}
