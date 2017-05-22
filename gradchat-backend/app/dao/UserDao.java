package dao;

import dto.UserDto;
import models.UserModel;

/**
 * Created by sameerap on 22/05/2017.
 */
public interface UserDao extends BaseDao<UserModel>{
    UserModel getLoggedInUser(UserDto userDto);
}
