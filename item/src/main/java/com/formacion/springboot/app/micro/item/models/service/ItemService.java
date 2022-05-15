package com.formacion.springboot.app.micro.item.models.service;

import com.formacion.springboot.app.commons.models.entity.Producto;
import com.formacion.springboot.app.micro.item.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);

    public Producto save(Producto producto);
    public Producto update(Producto producto, Long id);
    public void delete(Long id);
}
