package com.hiep.mart.domain.enumeration;

public enum ProductCategory {
    FRESH_FOOD("Thực phẩm tươi sống"),
    FROZEN_FOOD("Thực phẩm đông lạnh"),
    DRY_FOOD("Thực phẩm khô"),
    BEVERAGES("Đồ uống"),
    HEALTH_FOODS_SUPPLEMENTS("Thực phẩm chức năng"),
    DAIRY_PRODUCTS("Sản phẩm từ sữa"),
    HOUSEHOLD_ITEMS("Đồ dùng gia đình"),
    BEAUTY_PERSONAL_CARE("Sản phẩm làm đẹp và chăm sóc cá nhân"),
    BABY_CARE("Sản phẩm chăm sóc trẻ em"),
    HYGIENE_PRODUCTS("Sản phẩm vệ sinh cá nhân"),
    ORGANIC_FOOD("Thực phẩm hữu cơ"),
    PET_FOOD_SUPPLIES("Thức ăn cho thú cưng"),
    HEALTH_WELLNESS("Sản phẩm chăm sóc sức khỏe"),
    KITCHEN_SUPPLIES("Đồ dùng nhà bếp");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
