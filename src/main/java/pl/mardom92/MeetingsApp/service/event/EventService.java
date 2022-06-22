package pl.mardom92.MeetingsApp.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.CommentEntity;
import pl.mardom92.MeetingsApp.model.entity.EventEntity;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;
import pl.mardom92.MeetingsApp.model.mapper.EventMapper;
import pl.mardom92.MeetingsApp.repository.CommentRepository;
import pl.mardom92.MeetingsApp.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final EventServiceHelper eventServiceHelper;

    private final CommentRepository commentRepository;

    public List<EventDto> getAllEventsByStatus(List<EventStatus> statusList,
                                               int pageNumber,
                                               int sizeOnPage) {

        List<EventEntity> events = eventRepository.findAll();

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

        EventEntity event = eventServiceHelper.checkEventExist(id);

        return eventMapper.fromEntityToDto(event);
    }

    public void addEventWithComments(EventDto eventDto) {

        eventServiceHelper.checkEventDtoValues(eventDto);

        EventEntity event = eventMapper.fromDtoToEntity(eventDto);

        LocalDateTime now = LocalDateTime.now();
        event.setCreatedDate(now);

        for (CommentEntity c : event.getCommentList()) {
            c.setCreatedDate(now);
        }

        eventRepository.save(event);
        commentRepository.saveAll(event.getCommentList());
    }

    public void editEventWithComments(long id, EventDto eventDto) {

        eventServiceHelper.checkEventDtoValues(eventDto);

        EventEntity event = eventServiceHelper.checkEventExist(id);

        LocalDateTime createdDate = eventRepository.findById(id).get().getCreatedDate();

        event = eventMapper.fromDtoToEntity(eventDto);

        LocalDateTime now = LocalDateTime.now();

        event.setId(id);
        event.setCreatedDate(createdDate);
        event.setUpdatedDate(now);

        for (CommentEntity c : event.getCommentList()) {
            c.setCreatedDate(createdDate);
            c.setUpdatedDate(now);
        }

        eventRepository.save(event);
    }

    public void deleteEvent(long id) {

        EventEntity event = eventServiceHelper.checkEventExist(id);

        eventRepository.delete(event);
    }
}
