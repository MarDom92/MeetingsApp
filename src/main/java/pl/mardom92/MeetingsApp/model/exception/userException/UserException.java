package pl.mardom92.MeetingsApp.model.exception.userException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserException extends RuntimeException {

    private final UserError userError;
}
