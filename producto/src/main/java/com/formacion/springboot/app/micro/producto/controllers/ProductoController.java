package com.formacion.springboot.app.micro.producto.controllers;

import com.formacion.springboot.app.commons.models.entity.Producto;
import com.formacion.springboot.app.micro.producto.models.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    /**
     * El puerto lo podemos inyectar mediante Environment o con @Value
     */
    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar(){
        return productoService.findAll().stream().map(p -> {
            //p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
            p.setPort(port);
            return p;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) throws InterruptedException {

        if(id.equals(10L)){
            throw new IllegalStateException("Producto no encontrado!");
        }

        if(id.equals(7L)){
            TimeUnit.SECONDS.sleep(5l);
        }

        Producto producto = productoService.findById(id);
        //producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        producto.setPort(port);
        return producto;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto){
        return productoService.save(producto);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@RequestBody Producto producto, @PathVariable Long id){
        Producto productoDb = productoService.findById(id);

        productoDb.setNombre(producto.getNombre());
        productoDb.setPrecio(producto.getPrecio());

        return productoService.save(productoDb);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        productoService.deleteById(id);
    }
}
