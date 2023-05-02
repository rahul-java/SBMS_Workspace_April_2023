package sbms.app.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbms.app.postgres.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
