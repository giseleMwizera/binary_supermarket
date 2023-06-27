package rw.gisele.ne.binarysupermarket.services;

import rw.gisele.ne.binarysupermarket.dtos.CreateOrUpdateProductDTO;
import rw.gisele.ne.binarysupermarket.models.Product;

import java.util.List;

public interface IProductService {

    Product findByCode(String code);

    List<Product> all();

    Product register(CreateOrUpdateProductDTO dto);
}
