package pl.mardom92.MeetingsApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    public List<Comment> getAllComments() {
        return null;
    }

    public Comment getSingleComment(long id) {
        return null;
    }

    public Comment addComment(EventDto eventDto) {
        return null;
    }

    public Comment editComment(long id, EventDto eventDto) {

        return null;
    }

    public void deleteComment(long id) {

    }
}
