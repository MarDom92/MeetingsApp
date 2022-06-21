package pl.mardom92.MeetingsApp.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventDto {

    private String title;
    private String description;
    private String place;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private List<CommentDto> commentEntityList;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
