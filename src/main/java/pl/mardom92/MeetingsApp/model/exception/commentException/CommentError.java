package pl.mardom92.MeetingsApp.model.exception.commentException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommentError {

    COMMENT_NOT_FOUND("Comment does not exist."),
    COMMENT_EMPTY_LIST("List of comments is empty."),
    COMMENT_WRONG_FIELD_VALUE("Wrong event field value."),
    COMMENT_WRONG_DATE_FORMAT("Wrong date format.");

    private final String message;
}
