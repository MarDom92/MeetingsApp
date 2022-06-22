package pl.mardom92.MeetingsApp.model.builder.builder;

import pl.mardom92.MeetingsApp.model.entity.CommentEntity;

import java.time.LocalDateTime;

public class CommentBuilder {

    private long id;

    private long event_id;

    private String title;
    private String description;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public CommentBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CommentBuilder withEventId(long event_id) {
        this.event_id = event_id;
        return this;
    }

    public CommentBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CommentBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CommentBuilder withCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CommentBuilder withUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public CommentEntity build() {

        CommentEntity comment = new CommentEntity();

        comment.setId(id);
        comment.setEvent_id(event_id);
        comment.setTitle(title);
        comment.setDescription(description);
        comment.setCreatedDate(createdDate);
        comment.setUpdatedDate(updatedDate);

        return comment;
    }
}
