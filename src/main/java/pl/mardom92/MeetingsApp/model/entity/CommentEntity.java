package pl.mardom92.MeetingsApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long event_id;

    private String title;
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
