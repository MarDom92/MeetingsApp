package pl.mardom92.MeetingsApp.service.user;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.dto.UserDto;
import pl.mardom92.MeetingsApp.model.entity.User;
import pl.mardom92.MeetingsApp.model.exception.userException.UserError;
import pl.mardom92.MeetingsApp.model.exception.userException.UserException;

import java.util.List;

@Component
public class UserServiceHelper {

    protected void checkEmptyList(List<User> users) {

        if (users.isEmpty()) {
            throw new UserException(UserError.USER_EMPTY_LIST);
        }
    }

    protected void checkUserValues(UserDto userDto) {

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
    }
}
