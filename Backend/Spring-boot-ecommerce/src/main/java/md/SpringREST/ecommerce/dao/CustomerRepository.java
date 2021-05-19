package md.SpringREST.ecommerce.dao;

import md.SpringREST.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Babin Sergiu
 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
