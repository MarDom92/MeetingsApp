package pl.mardom92.MeetingsApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;
    private String title;
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
