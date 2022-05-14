package pl.mardom92.MeetingsApp.model.exception.eventException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventError {

    EVENT_NOT_FOUND("Event does not exist."),
    EVENT_EMPTY_LIST("List of events is empty."),
    EVENT_WRONG_PAGE_NUMBER_VALUE("Page number has wrong value."),
    EVENT_SIZE_ON_PAGE_TOO_GREAT("Size on page is too great."),
    EVENT_SIZE_ON_PAGE_TOO_SMALL("Size on page is too small."),
    EVENT_WRONG_FIELD_VALUE("Wrong event field value."),
    EVENT_WRONG_DATE_FORMAT("Wrong date format.");

    private final String message;
}
