package pl.mardom92.MeetingsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mardom92.MeetingsApp.model.entity.User;
import pl.mardom92.MeetingsApp.model.enums.UserRole;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByUserRoleIn(List<UserRole> userRoleList);

    Optional<User> findByEmail(String email);
}
