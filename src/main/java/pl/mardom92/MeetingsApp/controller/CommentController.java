package pl.mardom92.MeetingsApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;
import pl.mardom92.MeetingsApp.service.comment.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/")
    public List<Comment> getAllEvents() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getSingleEvents(@PathVariable long id) {
        return commentService.getSingleComment(id);
    }

    @PostMapping("/")
    public Comment addEvent(@RequestBody EventDto eventDto) {
        return commentService.addComment(eventDto);
    }

    @PutMapping("/{id}")
    public Comment editEvent(@PathVariable long id, @RequestBody EventDto eventDto) {
        return commentService.editComment(id, eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable long id) {
        commentService.deleteComment(id);
    }
}
