package services;

import dto.UserDto;

import java.util.List;

/**
 * Created by sameerap on 22/05/2017.
 */
public interface UserManagementService {
    void createUser(UserDto userDto);
    List<UserDto> getAllUsers();

    UserDto findUser(UserDto userDto);

    UserDto loginUser(UserDto userDto);
}
