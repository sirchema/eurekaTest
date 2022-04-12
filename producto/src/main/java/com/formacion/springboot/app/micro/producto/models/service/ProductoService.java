package com.formacion.springboot.app.micro.producto.models.service;

import com.formacion.springboot.app.micro.producto.models.entity.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);
}
