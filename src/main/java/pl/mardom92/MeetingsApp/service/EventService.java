package pl.mardom92.MeetingsApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.Event;
import pl.mardom92.MeetingsApp.repository.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event getSingleEvent(long id) {
        return eventRepository.findById(id)
                .orElseThrow();
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event editEvent(Event event) {

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
        eventRepository.deleteById(id);
    }
}
