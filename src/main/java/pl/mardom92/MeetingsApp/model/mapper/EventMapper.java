package pl.mardom92.MeetingsApp.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.builder.builder.EventEntityBuilder;
import pl.mardom92.MeetingsApp.model.builder.dtoBuilder.EventDtoBuilder;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.EventEntity;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventMapper {

    public final CommentMapper commentMapper;

    public EventEntity fromDtoToEntity(EventDto eventDto) {

        if (eventDto == null) {
            return null;
        }

        EventEntityBuilder eventEntityBuilder = new EventEntityBuilder();

        if (Objects.nonNull(eventDto.getTitle())) {
            eventEntityBuilder.withTitle(eventDto.getTitle());
        }

        if (Objects.nonNull(eventDto.getDescription())) {
            eventEntityBuilder.withDescription(eventDto.getDescription());
        }

        if (Objects.nonNull(eventDto.getPlace())) {
            eventEntityBuilder.withPlace(eventDto.getPlace());
        }

        if (Objects.nonNull(eventDto.getStatus())) {
            eventEntityBuilder.withStatus(eventDto.getStatus());
        }

        if (Objects.nonNull(eventDto.getCommentEntityList())) {
            eventEntityBuilder.withCommentList(
                    eventDto.getCommentEntityList().stream()
                            .map(commentDto -> commentMapper.fromDtoToEntity(commentDto))
                            .collect(Collectors.toList())
            );
        }

        if (Objects.nonNull(eventDto.getStartDate())) {
            eventEntityBuilder.withStartDate(eventDto.getStartDate());
        }

        if (Objects.nonNull(eventDto.getEndDate())) {
            eventEntityBuilder.withEndDate(eventDto.getEndDate());
        }

        return eventEntityBuilder.build();
    }

    public EventDto fromEntityToDto(EventEntity eventEntity) {

        if (eventEntity == null) {
            return null;
        }

        EventDtoBuilder eventDtoBuilder = new EventDtoBuilder();

        if (Objects.nonNull(eventEntity.getTitle())) {
            eventDtoBuilder.withTitle(eventEntity.getTitle());
        }

        if (Objects.nonNull(eventEntity.getDescription())) {
            eventDtoBuilder.withDescription(eventEntity.getDescription());
        }

        if (Objects.nonNull(eventEntity.getPlace())) {
            eventDtoBuilder.withPlace(eventEntity.getPlace());
        }

        if (Objects.nonNull(eventEntity.getStatus())) {
            eventDtoBuilder.withStatus(eventEntity.getStatus());
        }

        if (Objects.nonNull(eventEntity.getCommentEntityList())) {
            eventDtoBuilder.withCommentList(
                    eventEntity.getCommentEntityList().stream()
                            .map(commentDto -> commentMapper.fromEntityToDto(commentDto))
                            .collect(Collectors.toList())
            );
        }

        if (Objects.nonNull(eventEntity.getStartDate())) {
            eventDtoBuilder.withStarDate(eventEntity.getStartDate());
        }

        if (Objects.nonNull(eventEntity.getEndDate())) {
            eventDtoBuilder.withEndDate(eventEntity.getEndDate());
        }

        return eventDtoBuilder.build();
    }
}
