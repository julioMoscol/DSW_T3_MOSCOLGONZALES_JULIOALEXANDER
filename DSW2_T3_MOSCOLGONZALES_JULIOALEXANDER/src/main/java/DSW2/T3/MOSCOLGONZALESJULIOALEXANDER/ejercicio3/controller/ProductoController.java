package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.controller;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ProductoDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Producto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {

    private final IProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> registrarProducto(@RequestBody ProductoDto productoDto) {
        return new ResponseEntity<>(productoService.registrarProducto(productoDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable("id") Integer idproducto) {
        return new ResponseEntity<>(productoService.buscarProductoPorId(idproducto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Integer idproducto, @RequestBody ProductoDto productoDto) {
        return new ResponseEntity<>(productoService.actualizarProducto(idproducto, productoDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Integer idproducto) {
        productoService.eliminarProducto(idproducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
