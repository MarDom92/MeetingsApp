package pl.mardom92.MeetingsApp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventDto {

    private String title;
    private String description;
    private String place;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
