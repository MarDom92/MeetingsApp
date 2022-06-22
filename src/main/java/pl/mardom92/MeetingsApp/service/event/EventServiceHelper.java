package pl.mardom92.MeetingsApp.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.EventEntity;
import pl.mardom92.MeetingsApp.model.exception.eventException.EventError;
import pl.mardom92.MeetingsApp.model.exception.eventException.EventException;
import pl.mardom92.MeetingsApp.repository.EventRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EventServiceHelper {

    private final EventRepository eventRepository;

    protected int checkSizeOfList(List<EventEntity> events) {

        if (events.isEmpty()) {
            throw new EventException(EventError.EVENT_EMPTY_LIST);
        } else {
            return events.size();
        }
    }

    protected int checkPageNumber(int pageNumber) {

        if (pageNumber < 1) {
            throw new EventException(EventError.EVENT_WRONG_PAGE_NUMBER_VALUE);
        }

        return pageNumber;
    }

    protected int checkSizeOnPage(int sizeOnPage, int maxSize) {

        if (sizeOnPage > maxSize) {
            throw new EventException(EventError.EVENT_SIZE_ON_PAGE_TOO_GREAT);
        } else if (sizeOnPage < 0) {
            throw new EventException(EventError.EVENT_SIZE_ON_PAGE_TOO_SMALL);
        } else if (sizeOnPage == 0) {
            sizeOnPage = maxSize;
        }

        return sizeOnPage;
    }

    protected EventEntity checkEventExist(long id) {

        return eventRepository.findById(id)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));
    }

    protected void checkEventDtoValues(EventDto eventDto) {

        if (eventDto.getTitle().trim().equals("")) {
            throw new EventException(EventError.EVENT_WRONG_FIELD_VALUE);
        }

        if (eventDto.getDescription().trim().equals("")) {
            throw new EventException(EventError.EVENT_WRONG_FIELD_VALUE);
        }

        if (eventDto.getPlace().trim().equals("")) {
            throw new EventException(EventError.EVENT_WRONG_FIELD_VALUE);
        }

        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
