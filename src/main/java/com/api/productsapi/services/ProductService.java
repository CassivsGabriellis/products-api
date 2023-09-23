package com.api.productsapi.services;

import com.api.productsapi.model.Product;
import com.api.productsapi.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Method to return a list of products
     *
     * @return List of Products
     */
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    /**
     * Method to return a product found by its id.
     *
     * @param id of the product that will be found.
     * @return Return a product by its id.
     */
    public Optional<Product> getById(Integer id) {
        return productRepository.getById(id);
    }

    /**
     * Method to add a product in the list.
     *
     * @param product to be added.
     * @return a product that will be added in the list.
     */
    public Product add(Product product) {
        return productRepository.add(product);
    }

    /**
     * Deletes a product by its specific id.
     *
     * @param id to be deleted.
     */
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    /**
     * Update a product in the list by its id.
     *
     * @param id of the product.
     * @param product to be updated.
     * @return an updated product.
     */

    public Product update(Integer id, Product product) {
        product.setId(id);

        return productRepository.update(product);
    }
}
