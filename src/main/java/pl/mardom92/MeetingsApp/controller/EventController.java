package pl.mardom92.MeetingsApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;
import pl.mardom92.MeetingsApp.service.event.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/events")
public class EventController {

    private final EventService eventService;

    @GetMapping("")
    public List<EventDto> getAllEventsByStatus(@RequestParam(required = false) List<EventStatus> statusList,
                                               @RequestParam(required = false) Integer page,
                                               @RequestParam(required = false) Integer size) {
        return eventService.getAllEventsByStatus(statusList, page, size);
    }

    @GetMapping("/{id}")
    public EventDto getSingleEvents(@PathVariable long id) {
        return eventService.getSingleEvent(id);
    }

    @GetMapping("/single/{id}")
    public EventDto getSingleEventWithComments(@PathVariable long id) {
        return eventService.getSingleEventWithComments(id);
    }

    @PostMapping("")
    public EventDto addEvent(@RequestBody EventDto eventDto) {
        return eventService.addEvent(eventDto);
    }

    @PutMapping("/{id}")
    public EventDto editEvent(@PathVariable long id, @RequestBody EventDto eventDto) {
        return eventService.editEvent(id, eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
    }
}
