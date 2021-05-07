package md.SpringREST.ecommerce.dao;

import md.SpringREST.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Babin Sergiu
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
}
