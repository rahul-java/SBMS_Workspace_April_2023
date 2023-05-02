package sbms.app.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbms.app.mysql.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
