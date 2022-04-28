package pl.mardom92.MeetingsApp.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mardom92.MeetingsApp.model.entity.Event;
import pl.mardom92.MeetingsApp.model.enums.EventStatus;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findEventByStatusIn(List<EventStatus> statusList, Pageable pageable);
}
