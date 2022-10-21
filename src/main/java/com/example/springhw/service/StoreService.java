package com.example.springhw.service;

import com.example.springhw.component.Basket;
import com.example.springhw.model.Item;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final Map<Integer, Item> items = new HashMap<>();

    private final Basket basket;


    public StoreService(Basket basket) {
        this.basket = basket;
    }

    @PostConstruct
    public void init() {
        items.put(1, new Item(1,"Смартфон",25000));
        items.put(2, new Item(2,"Наушники",3000));
        items.put(3, new Item(3,"Открытка",100));
        items.put(4, new Item(4,"Компьютер",75000));
    }

    public List<Item> get() {
        return basket.get();
    }

    public void  add(List<Integer> ids) {
         basket.add(
                 ids.stream()
                         .map(items::get).
                         collect(Collectors.toList()));
    }
}
