package pl.mardom92.MeetingsApp.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.MeetingsApp.model.builder.builder.EventBuilder;
import pl.mardom92.MeetingsApp.model.builder.dtoBuilder.EventDtoBuilder;
import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.Event;

import java.util.Objects;

@Component
public class EventMapper {

    public Event fromDtoToEntity(EventDto eventDto) {

        if (eventDto == null) {
            return null;
        }

        EventBuilder eventBuilder = new EventBuilder();

        if (Objects.nonNull(eventDto.getTitle())) {
            eventBuilder.withTitle(eventDto.getTitle());
        }

        if (Objects.nonNull(eventDto.getDescription())) {
            eventBuilder.withDescription(eventDto.getDescription());
        }

        if (Objects.nonNull(eventDto.getPlace())) {
            eventBuilder.withPlace(eventDto.getPlace());
        }

        if (Objects.nonNull(eventDto.getStatus())) {
            eventBuilder.withStatus(eventDto.getStatus());
        }

        if (Objects.nonNull(eventDto.getCommentList())) {
            eventBuilder.withCommentList(eventDto.getCommentList());
        }

        if (Objects.nonNull(eventDto.getStartDate())) {
            eventBuilder.withStartDate(eventDto.getStartDate());
        }

        if (Objects.nonNull(eventDto.getEndDate())) {
            eventBuilder.withEndDate(eventDto.getEndDate());
        }

        return eventBuilder.build();
    }

    public EventDto fromEntityToDto(Event event) {

        if (event == null) {
            return null;
        }

        EventDtoBuilder eventDtoBuilder = new EventDtoBuilder();

        if (Objects.nonNull(event.getTitle())) {
            eventDtoBuilder.withTitle(event.getTitle());
        }

        if (Objects.nonNull(event.getDescription())) {
            eventDtoBuilder.withDescription(event.getDescription());
        }

        if (Objects.nonNull(event.getPlace())) {
            eventDtoBuilder.withPlace(event.getPlace());
        }

        if (Objects.nonNull(event.getStatus())) {
            eventDtoBuilder.withStatus(event.getStatus());
        }

        if (Objects.nonNull(event.getCommentList())) {
            eventDtoBuilder.withCommentList(event.getCommentList());
        }

        if (Objects.nonNull(event.getStartDate())) {
            eventDtoBuilder.withStarDate(event.getStartDate());
        }

        if (Objects.nonNull(event.getEndDate())) {
            eventDtoBuilder.withEndDate(event.getEndDate());
        }

        return eventDtoBuilder.build();
    }
}
