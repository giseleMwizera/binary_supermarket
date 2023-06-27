package rw.gisele.ne.binarysupermarket.services;

import rw.gisele.ne.binarysupermarket.dtos.NewProductQuantityDTO;
import rw.gisele.ne.binarysupermarket.models.ProductQuantity;

public interface IProductQuantityService {

    Integer byProduct(String productCode);

    ProductQuantity newQuantity(NewProductQuantityDTO dto);
}
