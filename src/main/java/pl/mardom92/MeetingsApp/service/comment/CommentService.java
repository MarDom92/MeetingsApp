package pl.mardom92.MeetingsApp.service.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.entity.CommentEntity;
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

    public List<CommentDto> getAllComments(@RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) Integer size) {

        List<CommentEntity> commentEntityList;

        if (size == null || size <= 0) {
            size = commentRepository.findAll().size();
        }

        if (page == null || page < 1) {
            page = 1;
        }

        commentEntityList = commentRepository.findAll(PageRequest.of(page - 1, size)).toList();

        commentServiceHelper.checkEmptyList(commentEntityList);

        return commentEntityList.stream().map(commentMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public List<CommentEntity> getAllCommentsOfSingleEvent(long id) {

        List<CommentEntity> commentEntityList = commentRepository.findAllByEventId(id);

        commentServiceHelper.checkEmptyList(commentEntityList);

        return commentEntityList;
    }

    public List<CommentDto> getAllCommentsDtoOfSingleEvent(long id) {

        List<CommentEntity> commentEntityList = getAllCommentsOfSingleEvent(id);

        return commentEntityList.stream().map(commentMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public CommentDto getSingleComment(long id) {

        CommentEntity commentEntity = checkCommentExistById(id);

        return commentMapper.fromEntityToDto(commentEntity);
    }

    public CommentDto addComment(CommentDto commentDto) {

        commentServiceHelper.checkCommentValues(commentDto);

        CommentEntity commentEntity = commentMapper.fromDtoToEntity(commentDto);

        commentEntity.setCreatedDate(LocalDateTime.now());

        commentRepository.save(commentEntity);

        return commentMapper.fromEntityToDto(commentEntity);
    }

    public CommentDto editComment(long id, CommentDto commentDto) {

        commentServiceHelper.checkCommentValues(commentDto);

        CommentEntity commentEntity = commentRepository.findById(id)
                .orElseThrow(() -> new EventException(EventError.EVENT_NOT_FOUND));

        commentEntity.setTitle(commentDto.getTitle());
        commentEntity.setDescription(commentDto.getDescription());
        commentEntity.setCreatedDate(LocalDateTime.now());
        commentEntity.setEvent_id(commentDto.getEvent_id());

        commentRepository.save(commentEntity);

        return commentMapper.fromEntityToDto(commentEntity);
    }

    public void deleteComment(long id) {

        CommentEntity commentEntity = checkCommentExistById(id);

        commentRepository.delete(commentEntity);
    }

    public CommentEntity checkCommentExistById(long id) {

        return commentRepository.findById(id)
                .orElseThrow(() -> new CommentException(CommentError.COMMENT_NOT_FOUND));
    }
}
