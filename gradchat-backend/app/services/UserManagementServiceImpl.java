package services;

import com.avaje.ebean.Ebean;
import com.google.inject.Inject;
import dao.UserDao;
import dto.UserDto;
import models.UserModel;
import play.libs.Json;

import java.util.ArrayList;
import java.util.List;

public class UserManagementServiceImpl implements UserManagementService {
    @Inject
    UserDao userDao;

    @Override
    public void createUser(UserDto userDto) {
        UserModel userModel = new UserModel();
        userModel.setUserFirstName(userDto.getUserFirstName());
        userModel.setUserLastName(userDto.getUserLastName());
        userModel.setUserEmail(userDto.getUserEmail());
        userModel.setUserPassword(userDto.getUserPassword());
        userDao.add(userModel);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserModel> userModelList;

        List<UserDto> userDtoList = new ArrayList<>();
        userModelList = userDao.getAllRecords();
        for (UserModel userModel : userModelList){

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
    public UserDto getUserByID(Long id){
        UserModel user =  userDao.getDetailsById(id);
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserFirstName(user.getUserFirstName());
        userDto.setUserLastName(user.getUserLastName());
        userDto.setUserEmail(user.getUserEmail());
        userDto.setUserPassword(user.getUserPassword());
        return userDto;
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
    public UserDto loginUser(UserDto userDto) throws Exception {
        UserModel userModel = null;

        try{
            userModel = userDao.getLoggedInUser(userDto);
            userDto.setUserId(userModel.getUserId());
            userDto.setUserFirstName(userModel.getUserFirstName());
            userDto.setUserLastName(userModel.getUserLastName());
            userDto.setUserEmail(userModel.getUserEmail());
            userDto.setUserPassword(userModel.getUserPassword());
        } catch (Exception e){
            throw new Exception(e.getCause());
        }

        return userDto;
    }
}
