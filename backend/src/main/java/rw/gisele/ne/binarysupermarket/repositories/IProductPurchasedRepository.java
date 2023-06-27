package rw.gisele.ne.binarysupermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.gisele.ne.binarysupermarket.models.ProductPurchased;
import rw.gisele.ne.binarysupermarket.models.User;

import java.util.List;
import java.util.UUID;

public interface IProductPurchasedRepository extends JpaRepository<ProductPurchased, UUID> {
    List<ProductPurchased> findByCustomer(User customer);
}
