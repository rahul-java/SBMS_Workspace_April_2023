package sbms.app.db1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbms.app.db1.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
