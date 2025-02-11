package com.tit.week04.day1.generic_classes;

public class SmartWareHouse {

    public static void main(String[] args) {
        Storage<Electronics> elecStorage = new Storage<>();
        Storage<Furniture> furStorage = new Storage<>();
        Storage<Groceries> grocStorage = new Storage<>();


        elecStorage.addItem(new Electronics("AC", 32500, 54)); ;
        elecStorage.addItem (new Electronics("Phone", 12500, 28));

        furStorage.addItem (new Furniture("Chair", 5200, 106)); ;
        furStorage.addItem (new Furniture("Table", 7800, 66));

        grocStorage.addItem(new Groceries("Rice", 110, 250));
        grocStorage.addItem(new Groceries("Wheat", 60, 1050)); ;

        Storage.display(elecStorage.getItems());
        Storage.display(furStorage.getItems());
        Storage.display(grocStorage.getItems());
    }
}