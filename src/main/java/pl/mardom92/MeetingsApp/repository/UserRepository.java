package pl.mardom92.MeetingsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mardom92.MeetingsApp.model.entity.UserEntity;
import pl.mardom92.MeetingsApp.model.enums.UserRole;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUserByUserRoleIn(List<UserRole> userRoleList);
}
