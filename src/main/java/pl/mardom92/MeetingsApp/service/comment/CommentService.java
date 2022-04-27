package pl.mardom92.MeetingsApp.service.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;
import pl.mardom92.MeetingsApp.model.exception.commentException.CommentError;
import pl.mardom92.MeetingsApp.model.exception.commentException.CommentException;
import pl.mardom92.MeetingsApp.model.exception.eventException.EventError;
import pl.mardom92.MeetingsApp.model.exception.eventException.EventException;
import pl.mardom92.MeetingsApp.model.mapper.CommentMapper;
import pl.mardom92.MeetingsApp.repository.CommentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final CommentServiceHelper commentServiceHelper;

    public List<CommentDto> getAllComments() {

        List<Comment> comments = commentRepository.findAll();

        commentServiceHelper.checkEmptyList(comments);

        return comments.stream().map(commentMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public List<CommentDto> getAllCommentsOfSingleEvent(long id) {

        List<Comment> comments = commentRepository.findAllByEventId(id);

        commentServiceHelper.checkEmptyList(comments);

        return comments.stream().map(commentMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public CommentDto getSingleComment(long id) {

        Comment comment = checkComment(id);

        return commentMapper.fromEntityToDto(comment);
    }

    public CommentDto addComment(CommentDto commentDto) {

        commentServiceHelper.checkCommentValues(commentDto);

        Comment comment = commentMapper.fromDtoToEntity(commentDto);

        comment.setCreatedDate(LocalDateTime.now());

        commentRepository.save(comment);

        return commentMapper.fromEntityToDto(comment);
    }

    public CommentDto editComment(long id, CommentDto commentDto) {

        commentServiceHelper.checkCommentValues(commentDto);

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));

        comment.setTitle(commentDto.getTitle());
        comment.setDescription(commentDto.getDescription());
        comment.setCreatedDate(LocalDateTime.now());

        commentRepository.save(comment);

        return commentMapper.fromEntityToDto(comment);
    }

    public void deleteComment(long id) {

        Comment comment = checkComment(id);

        commentRepository.delete(comment);
    }

    public Comment checkComment(long id) {

        return commentRepository.findById(id)
                .orElseThrow(() -> new CommentException(CommentError.COMMENT_NOT_FOUND));
    }
}
