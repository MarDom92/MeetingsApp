package pl.mardom92.MeetingsApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.MeetingsApp.model.Event;
import pl.mardom92.MeetingsApp.service.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/events/{id}")
    public Event getSingleEvents(@PathVariable long id) {
        return eventService.getSingleEvent(id);
    }
}
