package dao;

import dto.UserDto;
import models.UserModel;

public interface UserDao extends BaseDao<UserModel>{
    UserModel getLoggedInUser(UserDto userDto);
}
