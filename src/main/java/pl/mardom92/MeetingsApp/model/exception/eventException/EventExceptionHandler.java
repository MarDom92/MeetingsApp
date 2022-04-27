package pl.mardom92.MeetingsApp.model.exception.eventException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EventExceptionHandler {

    @ExceptionHandler(value = EventException.class)
    public ResponseEntity<EventErrorInfo> handlerEventException(EventException exception) {

        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;

        return ResponseEntity.status(httpStatus).body(new EventErrorInfo(exception.getEventError().getMessage()));
    }
}
