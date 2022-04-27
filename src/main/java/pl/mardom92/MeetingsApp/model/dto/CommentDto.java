package pl.mardom92.MeetingsApp.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.MeetingsApp.model.entity.Event;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {

    private String title;
    private String description;

    private LocalDateTime createdDate;
}
