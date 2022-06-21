package pl.mardom92.MeetingsApp.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.CommentEntity;
import pl.mardom92.MeetingsApp.model.entity.EventEntity;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;
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

    public List<EventDto> getAllEventsByStatus(List<EventStatus> statusList, Integer page, Integer size) {

        if (size == null || size <= 0) {
            size = eventRepository.findAll().size();
        }

        if (page == null || page < 1) {
            page = 1;
        }

        List<EventEntity> eventEntityList;

        if (statusList == null) {
            eventEntityList = eventRepository.findAll(PageRequest.of(page - 1, size)).toList();
        } else {
            eventEntityList = eventRepository.findEventByStatusIn(statusList, PageRequest.of(page - 1, size));
        }

        eventServiceHelper.checkEmptyList(eventEntityList);

        return eventEntityList.stream().map(eventMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public EventDto getSingleEvent(long id) {

        EventEntity eventEntity = checkEvent(id);

        return eventMapper.fromEntityToDto(eventEntity);
    }

    public EventDto getSingleEventWithComments(long id) {

        EventEntity eventEntity = checkEvent(id);

        List<CommentEntity> commentEntityList = commentService.getAllCommentsOfSingleEvent(id);

        eventEntity.setCommentEntityList(commentEntityList);

        return eventMapper.fromEntityToDto(eventEntity);
    }

    public EventDto addEvent(EventDto eventDto) {

        eventServiceHelper.checkEventValues(eventDto);

        EventEntity eventEntity = eventMapper.fromDtoToEntity(eventDto);

        eventEntity.setCreatedDate(LocalDateTime.now());
        eventEntity.setUpdatedDate(LocalDateTime.now());

        eventRepository.save(eventEntity);

        return eventMapper.fromEntityToDto(eventEntity);
    }

    public EventDto editEvent(long id, EventDto eventDto) {

        eventServiceHelper.checkEventValues(eventDto);

        EventEntity eventEntity = eventRepository.findById(id)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));

        eventEntity.setTitle(eventDto.getTitle());
        eventEntity.setDescription(eventDto.getDescription());
        eventEntity.setPlace(eventDto.getPlace());
        eventEntity.setUpdatedDate(LocalDateTime.now());
        eventEntity.setStartDate(eventEntity.getStartDate());
        eventEntity.setEndDate(eventEntity.getEndDate());

        eventRepository.save(eventEntity);

        return eventMapper.fromEntityToDto(eventEntity);
    }

    public void deleteEvent(long id) {

        EventEntity eventEntity = checkEvent(id);

        eventRepository.delete(eventEntity);
    }

    public EventEntity checkEvent(long id) {

        return eventRepository.findById(id)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));
    }
}
