package com.formacion.springboot.app.micro.item.models.service;

import com.formacion.springboot.app.micro.item.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);
}
