package pl.mardom92.MeetingsApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.Event;
import pl.mardom92.MeetingsApp.model.exception.EventError;
import pl.mardom92.MeetingsApp.model.exception.EventException;
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

    public List<EventDto> getAllEvents() {

        List<Event> events = eventRepository.findAll();

        eventServiceHelper.checkEmptyList(events);

        return events.stream().map(eventMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public EventDto getSingleEvent(long id) {

        Event event = checkEvent(id);

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
