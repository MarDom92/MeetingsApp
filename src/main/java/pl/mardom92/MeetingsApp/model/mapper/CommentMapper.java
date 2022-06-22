package pl.mardom92.MeetingsApp.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.builder.builder.CommentBuilder;
import pl.mardom92.MeetingsApp.model.builder.dtoBuilder.CommentDtoBuilder;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.entity.CommentEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    public CommentEntity fromDtoToEntity(CommentDto commentDto) {

        if (commentDto == null) {
            return null;
        }

        CommentBuilder commentBuilder = new CommentBuilder();

        if (commentDto.getEvent_id() > 0) {
            commentBuilder.withEventId(commentDto.getEvent_id());
        }

        if (Objects.nonNull(commentDto.getTitle())) {
            commentBuilder.withTitle(commentDto.getTitle());
        }

        if (Objects.nonNull(commentDto.getDescription())) {
            commentBuilder.withDescription(commentDto.getDescription());
        }

        if (Objects.nonNull(commentDto.getCreatedDate())) {
            commentBuilder.withCreatedDate(commentDto.getCreatedDate());
        }

        if (Objects.nonNull(commentDto.getUpdatedDate())) {
            commentBuilder.withUpdatedDate(commentDto.getUpdatedDate());
        }

        return commentBuilder.build();
    }

    public List<CommentEntity> fromDtoListToEntityList(List<CommentDto> commentDtoList) {

        return commentDtoList.stream()
                .map(commentDto -> fromDtoToEntity(commentDto))
                .collect(Collectors.toList());
    }

    public CommentDto fromEntityToDto(CommentEntity comment) {

        if (comment == null) {
            return null;
        }

        CommentDtoBuilder commentDtoBuilder = new CommentDtoBuilder();

        if (comment.getEvent_id() > 0) {
            commentDtoBuilder.withEventId(comment.getEvent_id());
        }

        if (Objects.nonNull(comment.getTitle())) {
            commentDtoBuilder.withTitle(comment.getTitle());
        }

        if (Objects.nonNull(comment.getDescription())) {
            commentDtoBuilder.withDescription(comment.getDescription());
        }

        if (Objects.nonNull(comment.getCreatedDate())) {
            commentDtoBuilder.withCreatedDate(comment.getCreatedDate());
        }

        if (Objects.nonNull(comment.getCreatedDate())) {
            commentDtoBuilder.withCreatedDate(comment.getCreatedDate());
        }

        return commentDtoBuilder.build();
    }

    public List<CommentDto> fromEntityListToDtoList(List<CommentEntity> commentList) {

        return commentList.stream()
                .map(comment -> fromEntityToDto(comment))
                .collect(Collectors.toList());
    }
}
