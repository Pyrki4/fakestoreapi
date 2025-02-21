package com.fakestoreapi.tests.api.products;

import com.fakestoreapi.tests.api.base.BaseTest;
import com.fakestoreapi.products.assertions.ProductAssertions;
import com.fakestoreapi.products.dto.CreateProductDto;
import com.fakestoreapi.products.dto.NewProductDto;
import com.fakestoreapi.products.dto.ProductDto;
import com.fakestoreapi.products.steps.ProductsSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

public class ProductsTests extends BaseTest {

    ProductsSteps client = new ProductsSteps();

    @Test
    @DisplayName("shouldReturnAllProducts")
    void shouldReturnAllProducts() {
        List<ProductDto> products = client.getAllProducts(SC_OK);
        ProductAssertions.assertProductsFieldsNotEmpty(products);
    }

    @Test
    @DisplayName("shouldReturnSingleProductById")
    void shouldReturnSingleProductById() {
        int id = 1;
        ProductDto product = client.getProductById(id, SC_OK);
        ProductAssertions.assertProductFieldsNotNull(product);
    }

    @Test
    @DisplayName("shouldReturnLimitedCountOfProducts")
    void shouldReturnLimitedCountOfProducts() {
        int limit = 1;
        List<ProductDto> products = client.getProductsWithLimit(SC_OK, limit);
        ProductAssertions.assertProductsMatchLimit(products, limit);
    }

    @Test
    @DisplayName("shouldReturnSortedProducts")
    void shouldReturnSortedProducts() {
        String sort = "desc";
        List<ProductDto> products = client.getSortedProducts(SC_OK, sort);
        ProductAssertions.assertProductIdsSorted(products, sort);
    }

    @Test
    @DisplayName("shouldReturnAllCategories")
    void shouldReturnAllCategories() {
        List<String> expectedCategories = new ArrayList<>(
                List.of("jewelery",
                        "electronics",
                        "men's clothing",
                        "women's clothing"));
        List<String> actualCategories = client.getAllCategories(SC_OK);
        ProductAssertions.assertExpectedCategories(expectedCategories, actualCategories);
    }

    @Test
    @DisplayName("shouldReturnProductsWithCategory")
    void shouldReturnProductsWithCategory() {
        String category = "electronics";
        List<ProductDto> products = client.getProductsWithCategory(SC_OK, category);
        ProductAssertions.assertProductsInCategory(products, category);
    }

    @Test
    @DisplayName("shouldCreateNewProduct")
    void shouldCreateNewProduct() {
        CreateProductDto product = new CreateProductDto("title", 10.5, "category", "description", "image");
        NewProductDto createdProduct = client.createNewProduct(SC_OK, product);
        ProductAssertions.assertNewProductFields(product, createdProduct);
    }

    @Test
    @DisplayName("shouldUpdateProduct")
    void shouldUpdateProduct() {
        int productId = 7;
        CreateProductDto product = new CreateProductDto("title", 10.5, "category", "description", "image");
        NewProductDto updatedProduct = client.updateProduct(SC_OK, product, productId);
        ProductAssertions.assertNewProductFields(product, updatedProduct);
    }

    @Test
    @DisplayName("shouldReturnDeletedProduct")
    void shouldReturnDeletedProduct() {
        ProductDto product = new ProductDto(
                7,
                "White Gold Plated Princess",
                9.99,
                "Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her. Gifts to spoil your love more for Engagement, Wedding, Anniversary, Valentine's Day...",
                "jewelery",
                "https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg",
                new ProductDto.Rating(3, 400)
        );

        ProductDto deletedProduct = client.deleteProduct(SC_OK, product.getId());
        ProductAssertions.assertProductFields(product, deletedProduct);
    }
}
