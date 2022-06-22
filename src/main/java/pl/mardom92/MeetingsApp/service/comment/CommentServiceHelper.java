package pl.mardom92.MeetingsApp.service.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.entity.CommentEntity;
import pl.mardom92.MeetingsApp.model.exception.commentException.CommentError;
import pl.mardom92.MeetingsApp.model.exception.commentException.CommentException;
import pl.mardom92.MeetingsApp.repository.CommentRepository;

@Component
@RequiredArgsConstructor
public class CommentServiceHelper {

    private final CommentRepository commentRepository;

    protected int checkSizeOfList(int size) {

        if (size <= 0) {
            throw new CommentException(CommentError.COMMENT_EMPTY_LIST);
        } else {
            return size;
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

    protected CommentEntity checkCommentExist(long id) {

        return commentRepository.findById(id)
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
