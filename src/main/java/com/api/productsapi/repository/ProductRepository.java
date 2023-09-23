package com.api.productsapi.repository;

import com.api.productsapi.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<Product>();
    private Integer lastId = 0;

    /**
     * Method to return a list of products.
     * @return Return a list of products
     * */
    public List<Product> getAll() {
        return products;
    }

    /**
     * Method to return a product found by its id.
     * @param id of the product that will be found.
     * @return Return a product by its id.
     * */
    public Optional<Product> getById(Integer id) {
        return products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    /**
     * Method to add a product in the list.
     * @param product to be added.
     * @return a product that will be added in the list.
     * */
    public Product add(Product product) {
        lastId++;
        product.setId(lastId);
        products.add(product);
        return product;
    }

    /**
     * Deletes a product by its specific id.
     * @param id to be deleted.
     * */
    public void delete(Integer id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    /**
     * Update a product in the list by its id.
     * @param product to be updated.
     * @return an updated product.
     * */
    public Product update(Product product) {
        Optional<Product> foundProduct = getById(product.getId());
        if (foundProduct.isEmpty()) {
            throw new InputMismatchException("Product not found.");
        }

        delete(product.getId());

        products.add(product);

        return product;
    }
}
