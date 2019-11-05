package com.example.gorbovshop_v2.model;


public enum ItemCode {
    PADTHAI, SALTPPRCHKN, AVCADOSLD, TMPURASHRMP, SUSHIPLAT, BEEFDUMPLINGS, CHKNTACOS, BEEFSTRGNOFF,
    POUTINE, BUTTRCHKN;

    private final String[] DESCRIPTIONS = {"A delicious pad thai dish", "A delicious salt pepper chicken dish",
            "A delicious avocado salad dish",
            "A delicious shrimp dish", "A delicious sushi dish", "A delicious beef dumpling dish",
            "A delicious chicken taco dish", "A delicious beef stroganoff dish",
            "A delicious poutine dish", "A delicious butter chicken dish"};

    private final String[] NAMES = {"Pad Thai", "Salt & Pepper Chicken", "Avocado Salad", "Tempura Shrimp",
            "Sushi Platter", "Beef Dumplings", "Chicken Tacos", "Beef Stroganoff", "Poutine", "Butter Chicken"};

    private final int[] PRICES = {9, 10, 8, 6, 12, 10, 8, 9, 6, 9};

    private final int BASE_VALUE = 32240000;

    private int completeValue;
    private int price;
    private String itemDescription;
    private String name;

    ItemCode() {
        completeValue = BASE_VALUE + this.ordinal();
        name = NAMES[this.ordinal()];
        itemDescription = DESCRIPTIONS[this.ordinal()];
        price = PRICES[this.ordinal()];
    }

    public int getCode() {
        return completeValue;
    }

    public int getPrice() {return price;}

    public String getDescription() {
        return itemDescription;
    }

    public String getItemName() {
        return name;
    }

}
