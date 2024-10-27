package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.impl;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ProductoDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.exception.ResourceNotFoundException;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Producto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.repository.ProductoRepository;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository productoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Producto registrarProducto(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        producto.setCantidad(productoDto.getCantidad());
        producto.setPreciopublico(productoDto.getPreciopublico());
        producto.setStockminimo(productoDto.getStockminimo());
        producto.setStockmaximo(productoDto.getStockmaximo());
        producto.setPrecioproveedor(productoDto.getPrecioproveedor());
        producto.setTipoProducto(productoDto.getTipoProducto());
        producto.setProveedor(productoDto.getProveedor());
        producto.setEstado(productoDto.getEstado());
        producto.setAnimal(productoDto.getAnimal());
        return productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Producto buscarProductoPorId(Integer idproducto) {
        return productoRepository.findById(idproducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + idproducto));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Producto actualizarProducto(Integer idproducto, ProductoDto productoDto) {
        Producto productoExistente = productoRepository.findById(idproducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + idproducto));

        productoExistente.setNombre(productoDto.getNombre());
        productoExistente.setCantidad(productoDto.getCantidad());
        productoExistente.setPreciopublico(productoDto.getPreciopublico());
        productoExistente.setStockminimo(productoDto.getStockminimo());
        productoExistente.setStockmaximo(productoDto.getStockmaximo());
        productoExistente.setPrecioproveedor(productoDto.getPrecioproveedor());
        productoExistente.setTipoProducto(productoDto.getTipoProducto());
        productoExistente.setProveedor(productoDto.getProveedor());
        productoExistente.setEstado(productoDto.getEstado());
        productoExistente.setAnimal(productoDto.getAnimal());

        return productoRepository.save(productoExistente);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void eliminarProducto(Integer idproducto) {
        Producto productoExistente = productoRepository.findById(idproducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + idproducto));
        productoRepository.delete(productoExistente);
    }
}
