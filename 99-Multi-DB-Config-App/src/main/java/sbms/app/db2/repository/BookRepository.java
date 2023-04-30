package sbms.app.db2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbms.app.db2.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
