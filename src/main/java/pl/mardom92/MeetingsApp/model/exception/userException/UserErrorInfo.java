package pl.mardom92.MeetingsApp.model.exception.userException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserErrorInfo {

    private final String message;
}
