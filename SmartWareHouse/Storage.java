package com.tit.week04.day1.generic_classes;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WareHouseItem>{
    private List<T>list = new ArrayList<>();

    public void addItem(T item){
        list.add(item);
    }

    public List<T> getItems(){
        return list;
    }

    public static  void display(List<? extends WareHouseItem> list){
     for(WareHouseItem item : list){
         System.out.println(item);
     }
    }
}
