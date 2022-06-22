package pl.mardom92.MeetingsApp.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.dto.UserDto;
import pl.mardom92.MeetingsApp.model.entity.UserEntity;
import pl.mardom92.MeetingsApp.model.exception.userException.UserError;
import pl.mardom92.MeetingsApp.model.exception.userException.UserException;
import pl.mardom92.MeetingsApp.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserServiceHelper {

    private final UserRepository userRepository;

    protected void setDefaultValueOfUserExtraField(UserEntity user) {
        user.setExpired(false);
        user.setLocked(false);
        user.setCredentialsExpired(false);
        user.setEnabled(true);
    }

    protected void checkEmptyList(List<UserEntity> users) {

        if (users.isEmpty()) {
            throw new UserException(UserError.USER_EMPTY_LIST);
        }
    }

    protected UserEntity checkUserExist(long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserException(UserError.USER_NOT_FOUND));
    }

    protected void checkUserDtoValues(UserDto userDto) {

        if (userDto.getEmail().trim().equals("")) {
            throw new UserException(UserError.USER_WRONG_FIELD_VALUE);
        }

        if (userDto.getUsername().trim().equals("")) {
            throw new UserException(UserError.USER_WRONG_FIELD_VALUE);
        }

        if (userDto.getFirstname().trim().equals("")) {
            throw new UserException(UserError.USER_WRONG_FIELD_VALUE);
        }

        if (userDto.getLastname().trim().equals("")) {
            throw new UserException(UserError.USER_WRONG_FIELD_VALUE);
        }

        if (userDto.getUserRole().toString().trim().equals("")) {
            throw new UserException(UserError.USER_WRONG_FIELD_VALUE);
        }
    }
}
