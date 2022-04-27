package pl.mardom92.MeetingsApp.model.builder.builder;

import pl.mardom92.MeetingsApp.model.entity.Comment;
import pl.mardom92.MeetingsApp.model.entity.Event;

import java.time.LocalDateTime;

public class CommentBuilder {

    private long id;
    private String title;
    private String description;

    private Event event;

    private LocalDateTime createdDate;

    public CommentBuilder withId(long id) {
        this.id = id;
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

    public CommentBuilder withEvent(Event event) {
        this.event = event;
        return this;
    }

    public CommentBuilder withCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Comment build() {

        Comment comment = new Comment();

        comment.setId(id);
        comment.setTitle(title);
        comment.setDescription(description);
        comment.setEvent(event);
        comment.setCreatedDate(createdDate);

        return comment;
    }
}