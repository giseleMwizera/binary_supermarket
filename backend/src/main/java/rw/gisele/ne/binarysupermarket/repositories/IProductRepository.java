package rw.gisele.ne.binarysupermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.gisele.ne.binarysupermarket.models.Product;

public interface IProductRepository extends JpaRepository<Product,String> {
}
