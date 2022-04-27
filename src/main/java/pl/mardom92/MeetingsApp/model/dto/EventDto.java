package pl.mardom92.MeetingsApp.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.MeetingsApp.model.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventDto {

    private String title;
    private String description;
    private String place;

    private List<Comment> commentList;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
