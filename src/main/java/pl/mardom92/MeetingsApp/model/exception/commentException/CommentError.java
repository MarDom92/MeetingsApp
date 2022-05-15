package pl.mardom92.MeetingsApp.model.exception.commentException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommentError {

    COMMENT_NOT_FOUND("Comment does not exist."),
    COMMENT_EMPTY_LIST("List of commments is empty."),
    COMMENT_WRONG_PAGE_NUMBER_VALUE("Page number has wrong value."),
    COMMENT_SIZE_ON_PAGE_TOO_GREAT("Size on page is too great."),
    COMMENT_SIZE_ON_PAGE_TOO_SMALL("Size on page is too small."),
    COMMENT_WRONG_FIELD_VALUE("Wrong commment field value."),
    COMMENT_WRONG_DATE_FORMAT("Wrong date format.");

    private final String message;
}
