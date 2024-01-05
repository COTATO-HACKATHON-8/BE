package cotato.hackathon.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cotato.hackathon.domain.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}




