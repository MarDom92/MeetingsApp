package pl.mardom92.MeetingsApp.model.exception.userException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserError {

    USER_NOT_FOUND("User does not exist."),
    USER_IS_NOT_AUTHENTICATED("User is not authenticated."),
    USER_EMPTY_LIST("List of users is empty."),
    USER_WRONG_FIELD_VALUE("Wrong user field value.");

    private final String message;
}
