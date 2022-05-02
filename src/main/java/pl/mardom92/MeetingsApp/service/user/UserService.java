package pl.mardom92.MeetingsApp.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.UserDto;
import pl.mardom92.MeetingsApp.model.entity.User;
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

        List<User> users;

        if (userRoleList == null) {
            users = userRepository.findAll();
        } else {
            users = userRepository.findUserByUserRoleIn(userRoleList);
        }

        userServiceHelper.checkEmptyList(users);

        return users.stream().map(userMapper::fromEntityToDto).collect(Collectors.toList());
    }
}
