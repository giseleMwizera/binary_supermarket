package rw.gisele.ne.binarysupermarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.gisele.ne.binarysupermarket.services.IProductPurchasedService;
import rw.gisele.ne.binarysupermarket.dtos.PurchaseProductDTO;
import rw.gisele.ne.binarysupermarket.payload.ApiResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/purchasedProduct")
@CrossOrigin
public class ProductPurchasedController {
    private final IProductPurchasedService service;


    @Autowired
    public ProductPurchasedController(IProductPurchasedService service) {
        this.service = service;
    }

    @GetMapping("/loggedInUser")
    @PreAuthorize("hasAnyAuthority('CUSTOMER')")
    public ResponseEntity<ApiResponse> getAllByLoggedInCustomer() {
        return ResponseEntity.ok(ApiResponse.success(service.byLoggedInCustomer()));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(ApiResponse.success(service.all()));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('CUSTOMER')")
    public ResponseEntity<ApiResponse> purchase(@Valid @RequestBody PurchaseProductDTO dto) {
        return ResponseEntity.ok(ApiResponse.success(this.service.purchase(dto)));
    }
}
