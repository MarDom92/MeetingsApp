package pl.mardom92.MeetingsApp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {

    private String title;
    private String description;

    private LocalDateTime createdDate;
}
