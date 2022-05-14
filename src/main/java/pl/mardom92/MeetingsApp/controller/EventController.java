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
    public List<EventDto> getAllEventsByStatus(@RequestParam(required = false, name = "status") List<EventStatus> statusList,
                                               @RequestParam(required = false, defaultValue = "1", name = "page") Integer pageNumber,
                                               @RequestParam(required = false, defaultValue = "0", name = "size") Integer sizeOnPage) {
        return eventService.getAllEventsByStatus(statusList, pageNumber, sizeOnPage);
    }

    @GetMapping("/{id}")
    public EventDto getSingleEvents(@PathVariable long id) {
        return eventService.getSingleEvent(id);
    }

    @GetMapping("/with-comments/{id}")
    public EventDto getSingleEventWithComments(@PathVariable long id) {
        return eventService.getSingleEventWithComments(id);
    }

    @PostMapping("")
    public void addEvent(@RequestBody EventDto eventDto) {
        eventService.addEvent(eventDto);
    }

    @PutMapping("/{id}")
    public void editEvent(@PathVariable long id, @RequestBody EventDto eventDto) {
        eventService.editEvent(id, eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
    }
}
