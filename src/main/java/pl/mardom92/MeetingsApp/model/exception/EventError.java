package pl.mardom92.MeetingsApp.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventError {

    EVENT_NOT_FOUND("Event does not exist."),
    EVENT_EMPTY_LIST("List of events is empty."),
    WRONG_EVENT_FIELD_VALUE("Wrong event field value."),
    WRONG_EVENT_DATE_FORMAT("Wrong date format.");

    private final String message;
}
