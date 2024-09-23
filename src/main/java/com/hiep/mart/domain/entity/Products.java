package com.hiep.mart.domain.entity;

import java.util.Set;

//import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help.Ansi.Text;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Products {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @Column(name = "product_id")
    Long productId;
    @Column(name = "product_code")
    String productCode;
    @Column(name = "product_name")
    String productName;
    @Column(name = "product_price")
    Double productPrice;
    @Column(name = "product_unit")
    String productUnit;
    @Column(name = "product_description")
    String productDescription;
    @Column(name = "product_image")
    String productImage;
    @Column(name = "product_status")
    String productStatus;
    @Column(name = "product_brand")
    String productBrand;
    @Column(name = "inventory_quantity")
    Long inventoryQuantity;
    @Column(name = "information")
    String information;

    @OneToMany(mappedBy = "products")
    Set<Batch> batch;

    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    Set<Categories> categories;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Suppliers suppliers;

    @ManyToMany
    @JoinTable(
            name = "product_promotion",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "promotion_id")
    )
    Set<Promotion> promotions;
}
