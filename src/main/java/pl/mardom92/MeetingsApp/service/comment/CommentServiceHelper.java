package pl.mardom92.MeetingsApp.service.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;
import pl.mardom92.MeetingsApp.model.exception.commentException.CommentError;
import pl.mardom92.MeetingsApp.model.exception.commentException.CommentException;
import pl.mardom92.MeetingsApp.repository.CommentRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentServiceHelper {

    private final CommentRepository CommentRepository;

    protected int checkSizeOfList(List<Comment> comments) {

        if (comments.isEmpty()) {
            throw new CommentException(CommentError.COMMENT_EMPTY_LIST);
        } else {
            return comments.size();
        }
    }

    protected int checkPageNumber(int pageNumber) {

        if (pageNumber < 1) {
            throw new CommentException(CommentError.COMMENT_WRONG_PAGE_NUMBER_VALUE);
        }

        return pageNumber;
    }

    protected int checkSizeOnPage(int sizeOnPage, int maxSize) {

        if (sizeOnPage > maxSize) {
            throw new CommentException(CommentError.COMMENT_SIZE_ON_PAGE_TOO_GREAT);
        } else if (sizeOnPage < 0) {
            throw new CommentException(CommentError.COMMENT_SIZE_ON_PAGE_TOO_SMALL);
        } else if (sizeOnPage == 0) {
            sizeOnPage = maxSize;
        }

        return sizeOnPage;
    }

    protected Comment checkCommentExist(long id) {

        return CommentRepository.findById(id)
                .orElseThrow(() -> new CommentException(CommentError.COMMENT_NOT_FOUND));
    }

    protected void checkCommentDtoValues(CommentDto commentDto) {

        if (commentDto.getTitle().trim().equals("")) {
            throw new CommentException(CommentError.COMMENT_WRONG_FIELD_VALUE);
        }

        if (commentDto.getDescription().trim().equals("")) {
            throw new CommentException(CommentError.COMMENT_WRONG_FIELD_VALUE);
        }
    }
}
