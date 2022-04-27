package pl.mardom92.MeetingsApp.model.exception.eventException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EventErrorInfo {

    private final String message;
}
