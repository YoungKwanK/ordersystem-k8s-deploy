package com.beyond.product.product.domain;

import com.beyond.product.common.domain.BaseTimeEntity;
import com.beyond.product.product.dto.ProductUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private int price;
    private int stockQuantity;
    private String imagePath;

    private String memberEmail;

    public void updateImageUrl(String imageUrl) {
        this.imagePath = imageUrl;
    }

    public void updateStockQuantity(int productCount) {
        this.stockQuantity -= productCount;
    }

    public void cancelOrder(int cancelQuantity) {
        this.stockQuantity += cancelQuantity;
    }

    public void updateDTO(ProductUpdateDTO productUpdateDTO) {
        this.category = productUpdateDTO.getCategory();
        this.name = productUpdateDTO.getName();
        this.price = productUpdateDTO.getPrice();
        this.stockQuantity = productUpdateDTO.getStockQuantity();
    }
}
