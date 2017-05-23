package services;

import dto.UserDto;

import java.util.List;

public interface UserManagementService {
    void createUser(UserDto userDto);
    List<UserDto> getAllUsers();

    UserDto getUserByID(Long id);

    UserDto findUser(UserDto userDto);

    UserDto loginUser(UserDto userDto) throws Exception;
}
