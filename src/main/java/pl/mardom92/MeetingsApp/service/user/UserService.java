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

        List<UserEntity> userEntities;

        if (userRoleList == null) {
            userEntities = userRepository.findAll();
        } else {
            userEntities = userRepository.findUserByUserRoleIn(userRoleList);
        }

        userServiceHelper.checkEmptyList(userEntities);

        return userEntities.stream().map(userMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public UserDto getSingleUser(long id) {

        UserEntity userEntity = checkUser(id);

        return userMapper.fromEntityToDto(userEntity);
    }

    public UserDto addUser(UserDto userDto) {

        userServiceHelper.checkUserValues(userDto);

        UserEntity userEntity = userMapper.fromDtoToEntity(userDto);

        userRepository.save(userEntity);

        return userMapper.fromEntityToDto(userEntity);
    }

    public UserDto editUser(long id, UserDto userDto) {

        userServiceHelper.checkUserValues(userDto);

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserException(UserError.USER_NOT_FOUND));

        userEntity.setEmail(userDto.getEmail());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setFirstname(userDto.getFirstname());
        userEntity.setLastname(userDto.getLastname());
        userEntity.setUserRole(userDto.getUserRole());

        userRepository.save(userEntity);

        return userMapper.fromEntityToDto(userEntity);
    }

    public void deleteUser(long id) {

        UserEntity userEntity = checkUser(id);

        userRepository.delete(userEntity);
    }

    public UserEntity checkUser(long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserException(UserError.USER_NOT_FOUND));
    }
}
