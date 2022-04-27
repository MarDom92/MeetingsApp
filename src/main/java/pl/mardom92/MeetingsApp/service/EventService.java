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

        List<Event> events = eventRepository.findAll();

        eventRepository.save(event);

        return eventMapper.fromEntityToDto(event);
    }

    public Event editEvent(Event event) {

        //TODO: poprawić na edytowanie po id
        Event eventEdited = eventRepository.findById(event.getId()).orElseThrow();

        eventEdited.setTitle(eventEdited.getTitle());
        eventEdited.setDescription(eventEdited.getDescription());
        eventEdited.setPlace(eventEdited.getPlace());
        eventEdited.setUpdatedDate(eventEdited.getUpdatedDate());
        eventEdited.setStartDate(eventEdited.getStartDate());
        eventEdited.setEndDate(eventEdited.getEndDate());

        return eventRepository.save(event);
    }

    public void deleteEvent(long id) {

        Event event = checkEvent(id);

        eventRepository.delete(event);
    }

    public Event checkEvent(long id) {

        return eventRepository.findById(id)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));
    }

    public Event checkEvent(String title) {

        return eventRepository.findByTitle(title)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));
    }
}
