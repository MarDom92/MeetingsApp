package pl.mardom92.MeetingsApp.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.UserDto;
import pl.mardom92.MeetingsApp.model.entity.UserEntity;
import pl.mardom92.MeetingsApp.model.enums.UserRole;
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

        List<UserEntity> users = getAllOrSpecifiedNumberOfUsersByRole(userRoleList);

        return users.stream().map(userMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public List<UserEntity> getAllOrSpecifiedNumberOfUsersByRole(List<UserRole> userRoleList) {
        List<UserEntity> users;

        if (userRoleList == null) {
            users = userRepository.findAll();
        } else {
            users = userRepository.findUserByUserRoleIn(userRoleList);
        }

        return users;
    }

    public UserDto getSingleUser(long id) {

        UserEntity user = userServiceHelper.checkUserExist(id);

        return userMapper.fromEntityToDto(user);
    }

    public AuthenticatedPrincipal getAuthenticatedPrincipalInfo(@AuthenticationPrincipal AuthenticatedPrincipal principal) {

        return userServiceHelper.checkAuthenticatedPrincipal(principal);
    }

    public void addUser(UserDto userDto) {

        userServiceHelper.checkUserDtoValues(userDto);

        UserEntity user = userMapper.fromDtoToEntity(userDto);

        userServiceHelper.setDefaultValueOfUserExtraField(user);

        userRepository.save(user);
    }

    public void editUser(long id, UserDto userDto) {

        userServiceHelper.checkUserDtoValues(userDto);

        UserEntity userInDB = userServiceHelper.checkUserExist(id);

        userInDB = userMapper.fromDtoToEntity(userDto);
        userInDB.setId(id);

        userServiceHelper.setDefaultValueOfUserExtraField(userInDB);

        userRepository.save(userInDB);
    }

    public void deleteUser(long id) {

        UserEntity user = userServiceHelper.checkUserExist(id);

        userRepository.delete(user);
    }
}
