package pl.mardom92.MeetingsApp.service.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.EventEntity;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;
import pl.mardom92.MeetingsApp.model.mapper.EventMapper;
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

    public List<EventDto> getAllEventsByStatus(List<EventStatus> statusList,
                                               int pageNumber,
                                               int sizeOnPage) {

        int sizeOfList = Math.toIntExact(eventRepository.count());

        sizeOfList = eventServiceHelper.checkSizeOfList(sizeOfList);
        pageNumber = eventServiceHelper.checkPageNumber(pageNumber);
        sizeOnPage = eventServiceHelper.checkSizeOnPage(sizeOnPage, sizeOfList);

        List<EventEntity> events = getAllOrSpecifiedNumberOfEventsByStatus(statusList, pageNumber, sizeOnPage);

        return events.stream().map(eventMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public List<EventEntity> getAllOrSpecifiedNumberOfEventsByStatus(List<EventStatus> statusList,
                                                                     int pageNumber,
                                                                     int sizeOnPage) {

        List<EventEntity> events;

        if (statusList == null || statusList.isEmpty()) {
            events = eventRepository.findAll(PageRequest.of(pageNumber - 1, sizeOnPage)).toList();
        } else {
            events = eventRepository.findEventByStatusIn(statusList, PageRequest.of(pageNumber - 1, sizeOnPage));
        }

        return events;
    }

    public EventDto getSingleEvent(long id) {

        EventEntity event = eventServiceHelper.checkIfEventExist(id);

        return eventMapper.fromEntityToDto(event);
    }

    public void addEventWithComments(EventDto eventDto) {

        eventServiceHelper.checkEventDtoValues(eventDto);

        EventEntity event = eventMapper.fromDtoToEntity(eventDto);

        LocalDateTime now = LocalDateTime.now();
        event.setCreatedDate(now);

        event.getCommentList().stream().forEach(commentEntity -> {
            commentEntity.setCreatedDate(now);
            commentEntity.setEvent_id(eventRepository.count() + 1);
        });

        eventRepository.save(event);
    }

    public void editEventWithComments(long id, EventDto eventDto) {

        EventEntity event = eventServiceHelper.checkIfEventExist(id);

        eventServiceHelper.checkEventDtoValues(eventDto);

        LocalDateTime createdDate = event.getCreatedDate();

        event = eventMapper.fromDtoToEntity(eventDto);

        LocalDateTime now = LocalDateTime.now();
        event.setId(id);
        event.setCreatedDate(createdDate);
        event.setUpdatedDate(now);

        event.getCommentList().stream().forEach(commentEntity -> {
            commentEntity.setCreatedDate(createdDate);
            commentEntity.setUpdatedDate(now);
            commentEntity.setEvent_id(id);
        });

        eventRepository.save(event);
    }

    public void deleteEvent(long id) {

        EventEntity event = eventServiceHelper.checkIfEventExist(id);

        eventRepository.delete(event);
    }
}
