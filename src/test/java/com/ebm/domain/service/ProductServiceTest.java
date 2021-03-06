package com.ebm.domain.service;

import com.ebm.domain.Product;
import com.ebm.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class ProductServiceTest {
    ProductService tester;
    ProductRepository productRepository;

    @BeforeEach
    void initEach() {
        productRepository = Mockito.mock(ProductRepository.class);
        tester = new ProductService(productRepository);
    }


    @Test
    void TestGetAllWithOutData() {
        assertEquals(new ArrayList<>(), tester.getAll(), "getAll must be []");
    }


    @Test
    void TestGetAllWithData() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        products.add(product);
        when(productRepository.getAll()).thenReturn(products);

        List<Product> productsResult = tester.getAll();

        assertEquals(1, productsResult.size(), "getAll must have a product");
        assertEquals(product, productsResult.toArray()[0], "getAll must have a product equal to object defined");
    }

    @Test
    void TestGetProductByIdWithOutData() {
        assertEquals(Optional.empty(), tester.getProductById(1), "getProductById must be Optional.empty()");
    }

    @Test
    void TestGetProductByIdWithData() {
        Optional<Product> products = Optional.of(new Product());
        when(productRepository.getProductById(1)).thenReturn(products);

        Optional<Product> productsResult = tester.getProductById(1);

        assertEquals(products, productsResult, "getAll must have a product");
    }


    @Test
    void TestGetProductsByUserIdWithOutData() {
        assertEquals(new ArrayList<>(), tester.getProductsByUserId(1), "getProductsByUserId must be [])");
    }


    @Test
    void TestGetProductsByUserIdWithData() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        products.add(product);

        when(productRepository.getProductsByUserId(1)).thenReturn(products);

        List<Product> productsResult = tester.getProductsByUserId(1);

        assertEquals(products, productsResult, "getProductsByUserId must have a product");
    }

    @Test
    void TestSaveNull() {
        assertNull(tester.save(new Product()), "save must be null");
    }

    @Test
    void TestSaveWithData() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);

        assertEquals(product, tester.save(product), "save must be new instance Product");
    }
}
