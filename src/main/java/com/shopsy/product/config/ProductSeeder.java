package com.shopsy.product.config;

import com.shopsy.product.entity.Product;
import com.shopsy.product.repository.ProductRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductSeeder {

    @Bean
    CommandLineRunner seedProducts(ProductRepository repository) {
        return args -> {
            if (repository.count() > 0) {
                return;
            }

            repository.save(create("iPhone 15", "Apple flagship smartphone", "Mobiles", "79999.00", 10));
            repository.save(create("Galaxy S24", "Samsung premium smartphone", "Mobiles", "74999.00", 12));
            repository.save(create("MacBook Air M3", "Lightweight Apple laptop", "Laptops", "114999.00", 7));
            repository.save(create("Sony WH-1000XM5", "Noise cancelling headphones", "Audio", "29999.00", 18));
            repository.save(create("Nike Running Shoes", "Comfortable running shoes", "Fashion", "5999.00", 30));
        };
    }

    private Product create(String name, String description, String category, String price, int stock) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(new BigDecimal(price));
        product.setStock(stock);
        product.setImageUrl("https://example.com/" + name.toLowerCase().replace(" ", "-"));
        return product;
    }
}
