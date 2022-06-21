package pl.mardom92.MeetingsApp.model.builder.builder;

import pl.mardom92.MeetingsApp.model.entity.CommentEntity;
import pl.mardom92.MeetingsApp.model.entity.EventEntity;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;

import java.time.LocalDateTime;
import java.util.List;

public class EventEntityBuilder {

    private long id;
    private String title;
    private String description;
    private String place;

    private EventStatus status;

    private List<CommentEntity> commentEntityList;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public EventEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public EventEntityBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public EventEntityBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EventEntityBuilder withPlace(String place) {
        this.place = place;
        return this;
    }

    public EventEntityBuilder withStatus(EventStatus status) {
        this.status = status;
        return this;
    }

    public EventEntityBuilder withCommentList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
        return this;
    }

    public EventEntityBuilder withCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public EventEntityBuilder withUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public EventEntityBuilder withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventEntityBuilder withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventEntity build() {

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId(id);
        eventEntity.setTitle(title);
        eventEntity.setDescription(description);
        eventEntity.setPlace(place);
        eventEntity.setCommentEntityList(commentEntityList);
        eventEntity.setCreatedDate(createdDate);
        eventEntity.setUpdatedDate(updatedDate);
        eventEntity.setStartDate(startDate);
        eventEntity.setEndDate(endDate);

        return eventEntity;
    }
}
