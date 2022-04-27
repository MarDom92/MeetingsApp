package pl.mardom92.MeetingsApp.model.builder.dtoBuilder;

import pl.mardom92.MeetingsApp.model.dto.CommentDto;

import java.time.LocalDateTime;

public class CommentDtoBuilder {

    private long event_id;

    private String title;
    private String description;

    private LocalDateTime createdDate;

    public CommentDtoBuilder withEventId(long event_id) {
        this.event_id = event_id;
        return this;
    }

    public CommentDtoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CommentDtoBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CommentDtoBuilder withCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CommentDto build() {

        CommentDto commentDto = new CommentDto();

        commentDto.setEvent_id(event_id);
        commentDto.setTitle(title);
        commentDto.setDescription(description);
        commentDto.setCreatedDate(createdDate);

        return commentDto;
    }
}
