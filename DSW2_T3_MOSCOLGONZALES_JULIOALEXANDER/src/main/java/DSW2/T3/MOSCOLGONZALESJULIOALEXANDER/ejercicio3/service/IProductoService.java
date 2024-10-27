package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ProductoDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Producto;

import java.util.List;

public interface IProductoService {

    Producto registrarProducto(ProductoDto productoDto);
    List<Producto> listarProductos();
    Producto buscarProductoPorId(Integer idproducto);
    Producto actualizarProducto(Integer idproducto, ProductoDto productoDto);
    void eliminarProducto(Integer idproducto);
}
