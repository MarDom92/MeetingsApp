package pl.mardom92.MeetingsApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Event {

    @Id
    private long id;
    private String title;
    private String description;
    private String place;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
