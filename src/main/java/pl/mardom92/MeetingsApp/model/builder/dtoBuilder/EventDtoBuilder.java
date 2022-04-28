package pl.mardom92.MeetingsApp.model.builder.dtoBuilder;

import pl.mardom92.MeetingsApp.model.dto.EventDto;
import pl.mardom92.MeetingsApp.model.entity.Comment;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;

import java.time.LocalDateTime;
import java.util.List;

public class EventDtoBuilder {

    private String title;
    private String description;
    private String place;

    private EventStatus status;

    private List<Comment> commentList;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public EventDtoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public EventDtoBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EventDtoBuilder withPlace(String place) {
        this.place = place;
        return this;
    }

    public EventDtoBuilder withStatus(EventStatus status) {
        this.status = status;
        return this;
    }

    public EventDtoBuilder withCommentList(List<Comment> commentList) {
        this.commentList = commentList;
        return this;
    }

    public EventDtoBuilder withStarDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventDtoBuilder withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventDto build() {

        EventDto eventDto = new EventDto();

        eventDto.setTitle(title);
        eventDto.setDescription(description);
        eventDto.setPlace(place);
        eventDto.setStatus(status);
        eventDto.setCommentList(commentList);
        eventDto.setStartDate(startDate);
        eventDto.setEndDate(endDate);

        return eventDto;
    }
}
