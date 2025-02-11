package com.tit.week04.day1.generic_classes;


abstract class WareHouseItem {
    private String name;
    private double price;
    private int quantity;

    public WareHouseItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+":"+
                " " + name  +
                ", " + price +
                ", " + quantity +
                '}';
    }
}
