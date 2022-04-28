package pl.mardom92.MeetingsApp.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;
import pl.mardom92.MeetingsApp.model.entity.Event;
import pl.mardom92.MeetingsApp.model.exception.eventException.EventError;
import pl.mardom92.MeetingsApp.model.exception.eventException.EventException;
import pl.mardom92.MeetingsApp.model.mapper.EventMapper;
import pl.mardom92.MeetingsApp.repository.EventRepository;
import pl.mardom92.MeetingsApp.service.comment.CommentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final EventServiceHelper eventServiceHelper;

    private final CommentService commentService;

    public List<EventDto> getAllEvents(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {

        Page<Event> events;

        if (size == null || size <= 0) {
            size = eventRepository.findAll().size();
        }

        if (page == null || page < 1) {
            page = 1;
        }

        events = eventRepository.findAll(PageRequest.of(page - 1, size));

        eventServiceHelper.checkEmptyList(events);

        return events.stream().map(eventMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public EventDto getSingleEvent(long id) {

        Event event = checkEvent(id);

        return eventMapper.fromEntityToDto(event);
    }

    public EventDto getSingleEventWithComments(long id) {

        Event event = checkEvent(id);

        List<Comment> comments = commentService.getAllCommentsOfSingleEvent(id);

        event.setCommentList(comments);

        return eventMapper.fromEntityToDto(event);
    }

    public EventDto addEvent(EventDto eventDto) {

        eventServiceHelper.checkEventValues(eventDto);

        Event event = eventMapper.fromDtoToEntity(eventDto);

        event.setCreatedDate(LocalDateTime.now());
        event.setUpdatedDate(LocalDateTime.now());

        eventRepository.save(event);

        return eventMapper.fromEntityToDto(event);
    }

    public EventDto editEvent(long id, EventDto eventDto) {

        eventServiceHelper.checkEventValues(eventDto);

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));

        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setPlace(eventDto.getPlace());
        event.setUpdatedDate(LocalDateTime.now());
        event.setStartDate(event.getStartDate());
        event.setEndDate(event.getEndDate());

        eventRepository.save(event);

        return eventMapper.fromEntityToDto(event);
    }

    public void deleteEvent(long id) {

        Event event = checkEvent(id);

        eventRepository.delete(event);
    }

    public Event checkEvent(long id) {

        return eventRepository.findById(id)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));
    }
}
