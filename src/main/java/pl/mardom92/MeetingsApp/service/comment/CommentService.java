package pl.mardom92.MeetingsApp.service.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.CommentEntity;
import pl.mardom92.MeetingsApp.model.entity.EventEntity;
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

    public List<CommentDto> getAllComments(int pageNumber,
                                           int sizeOnPage) {

        int sizeOfList = Math.toIntExact(commentRepository.count());

        sizeOfList = commentServiceHelper.checkSizeOfList(sizeOfList);
        pageNumber = commentServiceHelper.checkPageNumber(pageNumber);
        sizeOnPage = commentServiceHelper.checkSizeOnPage(sizeOnPage, sizeOfList);

        List<CommentEntity> comments = commentRepository.findAll(PageRequest.of(pageNumber - 1, sizeOnPage)).toList();

        return comments.stream().map(commentMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public List<CommentDto> getAllCommentsOfSingleEvent(long id) {

        List<CommentEntity> comments = commentRepository.findAllByEventId(id);

        commentServiceHelper.checkSizeOfList(comments.size());

        return comments.stream().map(commentMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public CommentDto getSingleComment(long id) {

        CommentEntity comment = commentServiceHelper.checkCommentExist(id);

        return commentMapper.fromEntityToDto(comment);
    }

    public void addComment(CommentDto commentDto) {

        commentServiceHelper.checkCommentDtoValues(commentDto);

        CommentEntity commentEntity = commentMapper.fromDtoToEntity(commentDto);

        commentEntity.setCreatedDate(LocalDateTime.now());

        commentRepository.save(commentEntity);
    }

    public void editComment(long id, CommentDto commentDto) {

        commentServiceHelper.checkCommentDtoValues(commentDto);

        CommentEntity commentInDB = commentServiceHelper.checkCommentExist(id);
        CommentEntity newComment = commentMapper.fromDtoToEntity(commentDto);

        commentInDB.setTitle(newComment.getTitle());
        commentInDB.setDescription(newComment.getDescription());
        commentInDB.setUpdatedDate(LocalDateTime.now());

        if (commentDto.getEvent_id() > 0) {
            commentInDB.setEvent_id(commentDto.getEvent_id());
        }

        commentRepository.save(commentInDB);
    }

    public void deleteComment(long id) {

        CommentEntity comment = commentServiceHelper.checkCommentExist(id);

        commentRepository.delete(comment);
    }
}
