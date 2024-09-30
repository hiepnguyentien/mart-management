package com.hiep.mart.repository;

public class Queries {

    public static final String SEARCH_PRODUCT_BY_CATEGORY = "Select * from products p\n" +
            "join public.categories_products cp on p.product_id = cp.products_product_id\n" +
            "join public.categories c on c.category_id = cp.categories_category_id\n" +
            "where c.category_id = :categoryId";



}
