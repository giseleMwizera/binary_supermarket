package rw.gisele.ne.binarysupermarket.serviceImpls;

import org.springframework.stereotype.Service;
import rw.gisele.ne.binarysupermarket.dtos.NewProductQuantityDTO;
import rw.gisele.ne.binarysupermarket.dtos.PurchaseProductDTO;
import rw.gisele.ne.binarysupermarket.models.ProductPurchased;
import rw.gisele.ne.binarysupermarket.models.ProductQuantity;
import rw.gisele.ne.binarysupermarket.models.User;
import rw.gisele.ne.binarysupermarket.repositories.IProductPurchasedRepository;
import rw.gisele.ne.binarysupermarket.services.IProductPurchasedService;
import rw.gisele.ne.binarysupermarket.services.IProductQuantityService;
import rw.gisele.ne.binarysupermarket.services.IUserService;
import rw.gisele.ne.binarysupermarket.enums.EProductQuantityOperation;

import java.util.List;

@Service
public class ProductPurchasedServiceImpl implements IProductPurchasedService {

    private final IProductPurchasedRepository repository;

    private final IUserService service;

    private final IProductQuantityService productQuantityService;

    public ProductPurchasedServiceImpl(IProductPurchasedRepository repository, IUserService service, IProductQuantityService productQuantityService) {
        this.repository = repository;
        this.service = service;
        this.productQuantityService = productQuantityService;
    }

    @Override
    public List<ProductPurchased> byLoggedInCustomer() {
        User customer = service.getLoggedInUser();
        return repository.findByCustomer(customer);
    }

    @Override
    public List<ProductPurchased> all() {
        return repository.findAll();
    }

    @Override
    public ProductPurchased purchase(PurchaseProductDTO dto) {
        User customer = service.getLoggedInUser();

        NewProductQuantityDTO newProductQuantityDTO = new NewProductQuantityDTO(dto.getCode(),dto.getQuantity(), EProductQuantityOperation.OUT);

        ProductQuantity productQuantity = productQuantityService.newQuantity(newProductQuantityDTO);

        ProductPurchased productPurchased = new ProductPurchased(productQuantity,customer);

        return repository.save(productPurchased);
    }
}
