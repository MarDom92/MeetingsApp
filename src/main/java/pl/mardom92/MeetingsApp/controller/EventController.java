package pl.mardom92.MeetingsApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.MeetingsApp.model.Event;
import pl.mardom92.MeetingsApp.service.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/events")
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public Event getSingleEvents(@PathVariable long id) {
        return eventService.getSingleEvent(id);
    }

    @PostMapping("/")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/")
    public Event editEvent(@RequestBody Event event) {
        return eventService.editEvent(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
    }
}
