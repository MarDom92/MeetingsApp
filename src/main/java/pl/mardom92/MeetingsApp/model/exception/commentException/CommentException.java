package pl.mardom92.MeetingsApp.model.exception.commentException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentException extends RuntimeException {

    private final CommentError commentError;
}
