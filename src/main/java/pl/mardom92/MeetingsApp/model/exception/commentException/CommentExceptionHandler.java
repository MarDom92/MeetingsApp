package pl.mardom92.MeetingsApp.model.exception.commentException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommentExceptionHandler {

    @ExceptionHandler(value = CommentException.class)
    public ResponseEntity<CommentErrorInfo> handlerCommentException(CommentException exception) {

        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;

        return ResponseEntity.status(httpStatus).body(new CommentErrorInfo(exception.getCommentError().getMessage()));
    }
}
