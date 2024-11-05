package com.hiep.mart.repository;

public class Queries {

    public static final String SEARCH_PRODUCT_BY_CATEGORY = "Select * from products p\n" +
            "join public.categories_products cp on p.product_id = cp.products_product_id\n" +
            "join public.categories c on c.category_id = cp.categories_category_id\n" +
            "where c.category_id = :categoryId";

    public static final String GET_PRODUCT_QUANTITY_IN_CART_BY_USER = "select c.quantity\n" +
            "    from cart c\n" +
            "where c.product_id = :productId\n" +
            "and c.user_id = :userId";

    public static final String FIND_CART_BY_USER_AND_PRODUCT = "select *\n" +
            "    from cart c \n" +
            "where c.product_id = :productId\n" +
            "and c.user_id = :userId";

    public static final String FIND_DISTRICT_BY_PROVINCE_CODE = "select *\n" +
            "    from districts\n" +
            "        where province_code = :provinceCode";

    public static final String FIND_WARD_BY_DISTRICT_CODE = "select *\n" +
            "    from wards\n" +
            "        where district_code = :districtCode;";
}
