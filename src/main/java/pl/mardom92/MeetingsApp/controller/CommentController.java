package pl.mardom92.MeetingsApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.service.comment.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/all")
    public List<CommentDto> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public List<CommentDto> getAllCommentsOfSingleEvent(@PathVariable long id) {
        return commentService.getAllCommentsDtoOfSingleEvent(id);
    }

    @GetMapping("/single/{id}")
    public CommentDto getSingleComments(@PathVariable long id) {
        return commentService.getSingleComment(id);
    }

    @PostMapping("/")
    public CommentDto addComment(@RequestBody CommentDto commentDto) {
        return commentService.addComment(commentDto);
    }

    @PutMapping("/{id}")
    public CommentDto editComment(@PathVariable long id, @RequestBody CommentDto commentDto) {
        return commentService.editComment(id, commentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable long id) {
        commentService.deleteComment(id);
    }
}
