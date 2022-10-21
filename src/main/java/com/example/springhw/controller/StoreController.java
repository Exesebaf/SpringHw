package com.example.springhw.controller;

import com.example.springhw.model.Item;
import com.example.springhw.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/add")
    public void add(@RequestParam("id")List<Integer> ids) {
         storeService.add(ids);
    }
    @GetMapping("/get")
    public List<Item> get() {
        return storeService.get();
    }
}
