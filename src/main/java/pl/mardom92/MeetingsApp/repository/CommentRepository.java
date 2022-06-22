package pl.mardom92.MeetingsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mardom92.MeetingsApp.model.entity.CommentEntity;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Query(value = "SELECT * FROM comment_entity WHERE event_id=?1", nativeQuery = true)
    List<CommentEntity> findAllByEventId(long id);
}
