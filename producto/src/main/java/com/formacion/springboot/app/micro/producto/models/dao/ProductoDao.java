package com.formacion.springboot.app.micro.producto.models.dao;

import com.formacion.springboot.app.micro.producto.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
}
