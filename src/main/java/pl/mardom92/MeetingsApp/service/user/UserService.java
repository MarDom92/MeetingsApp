package pl.mardom92.MeetingsApp.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.UserDto;
import pl.mardom92.MeetingsApp.model.entity.UserEntity;
import pl.mardom92.MeetingsApp.model.enums.UserRole;
import pl.mardom92.MeetingsApp.model.exception.userException.UserError;
import pl.mardom92.MeetingsApp.model.exception.userException.UserException;
import pl.mardom92.MeetingsApp.model.mapper.UserMapper;
import pl.mardom92.MeetingsApp.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserServiceHelper userServiceHelper;

    public List<UserDto> getAllUsersByRole(List<UserRole> userRoleList) {

        List<UserEntity> users;

        if (userRoleList == null) {
            users = userRepository.findAll();
        } else {
            users = userRepository.findUserByUserRoleIn(userRoleList);
        }

        userServiceHelper.checkEmptyList(users);

        return users.stream().map(userMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public UserDto getSingleUser(long id) {

        UserEntity user = checkUser(id);

        return userMapper.fromEntityToDto(user);
    }

    public UserDto addUser(UserDto userDto) {

        userServiceHelper.checkUserValues(userDto);

        UserEntity user = userMapper.fromDtoToEntity(userDto);

        userRepository.save(user);

        return userMapper.fromEntityToDto(user);
    }

    public UserDto editUser(long id, UserDto userDto) {

        userServiceHelper.checkUserValues(userDto);

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UserException(UserError.USER_NOT_FOUND));

        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setUserRole(userDto.getUserRole());

        userRepository.save(user);

        return userMapper.fromEntityToDto(user);
    }

    public void deleteUser(long id) {

        UserEntity user = checkUser(id);

        userRepository.delete(user);
    }

    public UserEntity checkUser(long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserException(UserError.USER_NOT_FOUND));
    }
}
