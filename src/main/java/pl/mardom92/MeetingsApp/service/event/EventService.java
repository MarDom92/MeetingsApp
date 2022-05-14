package pl.mardom92.MeetingsApp.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;
import pl.mardom92.MeetingsApp.model.entity.Event;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;
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

    public List<EventDto> getAllEventsByStatus(List<EventStatus> statusList,
                                               int pageNumber,
                                               int sizeOnPage) {

        List<Event> events = eventRepository.findAll();

        int sizeOfList = eventServiceHelper.checkSizeOfList(events);

        pageNumber = eventServiceHelper.checkPageNumber(pageNumber);

        sizeOnPage = eventServiceHelper.checkSizeOnPage(sizeOnPage, sizeOfList);

        if (statusList == null || statusList.isEmpty()) {
            events = eventRepository.findAll(PageRequest.of(pageNumber - 1, sizeOnPage)).toList();
        } else {
            events = eventRepository.findEventByStatusIn(statusList, PageRequest.of(pageNumber - 1, sizeOnPage));
        }

        return events.stream().map(eventMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public EventDto getSingleEvent(long id) {

        Event event = eventServiceHelper.checkEventExist(id);

        return eventMapper.fromEntityToDto(event);
    }

    public EventDto getSingleEventWithComments(long id) {

        Event event = eventServiceHelper.checkEventExist(id);

        List<Comment> comments = commentService.getAllCommentsOfSingleEvent(id);

        event.setCommentList(comments);

        return eventMapper.fromEntityToDto(event);
    }

    public void addEvent(EventDto eventDto) {

        eventServiceHelper.checkEventDtoValues(eventDto);

        Event event = eventMapper.fromDtoToEntity(eventDto);

        event.setCreatedDate(LocalDateTime.now());

        eventRepository.save(event);
    }

    public void editEvent(long id, EventDto eventDto) {

        eventServiceHelper.checkEventDtoValues(eventDto);

        Event event = eventServiceHelper.checkEventExist(id);

        event = eventMapper.fromDtoToEntity(eventDto);

        //TODO: fix saving comment
        event.setCommentList(null);
        event.setId(id);
        event.setUpdatedDate(LocalDateTime.now());

        eventRepository.save(event);
    }

    public void deleteEvent(long id) {

        Event event = eventServiceHelper.checkEventExist(id);

        eventRepository.delete(event);
    }
}
