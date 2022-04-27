package pl.mardom92.MeetingsApp.model.exception.eventException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventError {

    EVENT_NOT_FOUND("Event does not exist."),
    EVENT_EMPTY_LIST("List of events is empty."),
    EVENT_WRONG_FIELD_VALUE("Wrong event field value."),
    EVENT_WRONG_DATE_FORMAT("Wrong date format.");

    private final String message;
}
