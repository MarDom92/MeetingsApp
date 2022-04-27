package pl.mardom92.MeetingsApp.service.event;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.Event;
import pl.mardom92.MeetingsApp.model.exception.eventException.EventError;
import pl.mardom92.MeetingsApp.model.exception.eventException.EventException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class EventServiceHelper {

    protected void checkEmptyList(List<Event> events) {

        if (events.isEmpty()) {
            throw new EventException(EventError.EVENT_EMPTY_LIST);
        }
    }

    protected void checkEventValues(EventDto eventDto) {

        if (eventDto.getTitle().trim().equals("")) {
            throw new EventException(EventError.EVENT_WRONG_FIELD_VALUE);
        }

        if (eventDto.getDescription().trim().equals("")) {
            throw new EventException(EventError.EVENT_WRONG_FIELD_VALUE);
        }

        if (eventDto.getPlace().trim().equals("")) {
            throw new EventException(EventError.EVENT_WRONG_FIELD_VALUE);
        }

        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

        try {
            format.parse(eventDto.getStartDate().toString());
        } catch (ParseException e) {
            new EventException(EventError.EVENT_WRONG_DATE_FORMAT);
        }

        try {
            format.parse(eventDto.getEndDate().toString());
        } catch (ParseException e) {
            new EventException(EventError.EVENT_WRONG_DATE_FORMAT);
        }
    }
}
