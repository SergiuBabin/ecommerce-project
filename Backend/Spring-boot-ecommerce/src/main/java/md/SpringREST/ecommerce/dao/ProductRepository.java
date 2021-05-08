package md.SpringREST.ecommerce.dao;

import md.SpringREST.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Babin Sergiu
 */
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(@RequestParam("id") Long id);
}
