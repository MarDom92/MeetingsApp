package pl.mardom92.MeetingsApp.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.builder.builder.CommentEntityBuilder;
import pl.mardom92.MeetingsApp.model.builder.dtoBuilder.CommentDtoBuilder;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.entity.CommentEntity;

import java.util.Objects;

@Component
public class CommentMapper {

    public CommentEntity fromDtoToEntity(CommentDto commentDto) {

        if (commentDto == null) {
            return null;
        }

        CommentEntityBuilder commentEntityBuilder = new CommentEntityBuilder();

        if (commentDto.getEvent_id() > 0) {
            commentEntityBuilder.withEventId(commentDto.getEvent_id());
        }

        if (Objects.nonNull(commentDto.getTitle())) {
            commentEntityBuilder.withTitle(commentDto.getTitle());
        }

        if (Objects.nonNull(commentDto.getDescription())) {
            commentEntityBuilder.withDescription(commentDto.getDescription());
        }

        if (Objects.nonNull(commentDto.getCreatedDate())) {
            commentEntityBuilder.withCreatedDate(commentDto.getCreatedDate());
        }

        return commentEntityBuilder.build();
    }

    public CommentDto fromEntityToDto(CommentEntity commentEntity) {

        if (commentEntity == null) {
            return null;
        }

        CommentDtoBuilder commentDtoBuilder = new CommentDtoBuilder();

        if (commentEntity.getEvent_id() > 0) {
            commentDtoBuilder.withEventId(commentEntity.getEvent_id());
        }

        if (Objects.nonNull(commentEntity.getTitle())) {
            commentDtoBuilder.withTitle(commentEntity.getTitle());
        }

        if (Objects.nonNull(commentEntity.getDescription())) {
            commentDtoBuilder.withDescription(commentEntity.getDescription());
        }

        if (Objects.nonNull(commentEntity.getCreatedDate())) {
            commentDtoBuilder.withCreatedDate(commentEntity.getCreatedDate());
        }

        return commentDtoBuilder.build();
    }
}
