package pl.mardom92.MeetingsApp.service.comment;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;
import pl.mardom92.MeetingsApp.model.exception.commentException.CommentError;
import pl.mardom92.MeetingsApp.model.exception.commentException.CommentException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class CommentServiceHelper {

    protected void checkEmptyList(List<Comment> comments) {

        if (comments.isEmpty()) {
            throw new CommentException(CommentError.COMMENT_EMPTY_LIST);
        }
    }

    protected void checkCommentValues(CommentDto CommentDto) {

        if (CommentDto.getTitle().trim().equals("")) {
            throw new CommentException(CommentError.COMMENT_WRONG_FIELD_VALUE);
        }

        if (CommentDto.getDescription().trim().equals("")) {
            throw new CommentException(CommentError.COMMENT_WRONG_FIELD_VALUE);
        }

        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

        try {
            format.parse(CommentDto.getCreatedDate().toString());
        } catch (ParseException e) {
            new CommentException(CommentError.COMMENT_WRONG_DATE_FORMAT);
        }
    }
}
