package pl.mardom92.MeetingsApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.service.comment.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("")
    public List<CommentDto> getAllComments(@RequestParam(required = false, defaultValue = "1", name = "page") Integer pageNumber,
                                           @RequestParam(required = false, defaultValue = "0", name = "size") Integer sizeOnPage) {
        return commentService.getAllComments(pageNumber, sizeOnPage);
    }

    @GetMapping("/{id}")
    public List<CommentDto> getAllCommentsOfSingleEvent(@PathVariable long id) {
        return commentService.getAllCommentsOfSingleEvent(id);
    }

    @GetMapping("/single/{id}")
    public CommentDto getSingleComments(@PathVariable long id) {
        return commentService.getSingleComment(id);
    }

    @PostMapping("")
    public void addComment(@RequestBody CommentDto commentDto) {
        commentService.addComment(commentDto);
    }

    @PutMapping("/{id}")
    public void editComment(@PathVariable long id, @RequestBody CommentDto commentDto) {
        commentService.editComment(id, commentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable long id) {
        commentService.deleteComment(id);
    }
}
