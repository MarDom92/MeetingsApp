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
}
