package pl.mardom92.MeetingsApp.model.entity;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private String place;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "event_id", updatable = false, insertable = false)
    private List<CommentEntity> commentEntityList;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
}
