package pl.mardom92.MeetingsApp.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.builder.builder.CommentBuilder;
import pl.mardom92.MeetingsApp.model.builder.dtoBuilder.CommentDtoBuilder;
import pl.mardom92.MeetingsApp.model.dto.CommentDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CommentMapper {

    public Comment fromDtoToEntity(CommentDto commentDto) {

        if (commentDto == null) {
            return null;
        }

        CommentBuilder commentBuilder = new CommentBuilder();

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

    public List<Comment> fromDtosToEntities(List<CommentDto> commentDtos) {

        List<Comment> comments = new ArrayList<>();

        for (CommentDto c : commentDtos) {
            comments.add(fromDtoToEntity(c));
        }

        return comments;
    }

    public CommentDto fromEntityToDto(Comment comment) {

        if (comment == null) {
            return null;
        }

        CommentDtoBuilder commentDtoBuilder = new CommentDtoBuilder();

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

    public List<CommentDto> fromEntitiesToDtos(List<Comment> comments) {

        List<CommentDto> commentDtos = new ArrayList<>();

        for (Comment c : comments) {
            commentDtos.add(fromEntityToDto(c));
        }

        return commentDtos;
    }
}
