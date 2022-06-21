package pl.mardom92.MeetingsApp.model.builder.builder;

import pl.mardom92.MeetingsApp.model.entity.CommentEntity;

import java.time.LocalDateTime;

public class CommentEntityBuilder {

    private long id;

    private long event_id;

    private String title;
    private String description;

    private LocalDateTime createdDate;

    public CommentEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CommentEntityBuilder withEventId(long event_id) {
        this.event_id = event_id;
        return this;
    }

    public CommentEntityBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CommentEntityBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CommentEntityBuilder withCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CommentEntity build() {

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setId(id);
        commentEntity.setEvent_id(event_id);
        commentEntity.setTitle(title);
        commentEntity.setDescription(description);
        commentEntity.setCreatedDate(createdDate);

        return commentEntity;
    }
}
