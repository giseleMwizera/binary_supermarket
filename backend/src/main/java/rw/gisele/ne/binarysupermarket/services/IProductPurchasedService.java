package rw.gisele.ne.binarysupermarket.services;

import rw.gisele.ne.binarysupermarket.dtos.PurchaseProductDTO;
import rw.gisele.ne.binarysupermarket.models.ProductPurchased;

import java.util.List;

public interface IProductPurchasedService {

    List<ProductPurchased> byLoggedInCustomer();

    List<ProductPurchased> all();

    ProductPurchased purchase(PurchaseProductDTO dto);
}
