package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.utils.convert;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ProductoDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.exception.ResourceNotFoundException;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Producto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.repository.AnimalRepository; // Asegúrate de tener este repositorio
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoConvert {

    @Autowired
    private AnimalRepository animalRepository; // Inyecta el repositorio de Animal

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    public ProductoDto convertirProductoAProductoDto(Producto producto) {
        return ProductoDto.builder()
                .idproducto(producto.getIdproducto())
                .tipoProducto(producto.getTipoProducto())
                .proveedor(producto.getProveedor())
                .nombre(producto.getNombre())
                .cantidad(producto.getCantidad())
                .preciopublico(producto.getPreciopublico())
                .stockminimo(producto.getStockminimo())
                .stockmaximo(producto.getStockmaximo())
                .estado(producto.getEstado())
                .animal(producto.getAnimal()) // Asegúrate de incluir el animal aquí
                .precioproveedor(producto.getPrecioproveedor())
                .build();
    }

    public Producto convertirProductoDtoAProducto(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setIdproducto(productoDto.getIdproducto());

        // Validar que el ID del animal esté presente
        if (productoDto.getAnimal() != null && productoDto.getAnimal().getIdanimal() != null) {
            producto.setAnimal(animalRepository.findById(productoDto.getAnimal().getIdanimal())
                    .orElseThrow(() -> new ResourceNotFoundException("Animal not found")));
        } else {
            throw new ResourceNotFoundException("Animal ID is required");
        }

        // Validar que el ID del tipo de producto esté presente
        if (productoDto.getTipoProducto() != null && productoDto.getTipoProducto().getIdtipopro() != null) {
            producto.setTipoProducto(tipoProductoRepository.findById(productoDto.getTipoProducto().getIdtipopro())
                    .orElseThrow(() -> new ResourceNotFoundException("Tipo de producto not found")));
        } else {
            throw new ResourceNotFoundException("Tipo de producto ID is required");
        }

        producto.setProveedor(productoDto.getProveedor());
        producto.setNombre(productoDto.getNombre());
        producto.setCantidad(productoDto.getCantidad());
        producto.setPreciopublico(productoDto.getPreciopublico());
        producto.setStockminimo(productoDto.getStockminimo());
        producto.setStockmaximo(productoDto.getStockmaximo());
        producto.setEstado(productoDto.getEstado());
        producto.setPrecioproveedor(productoDto.getPrecioproveedor());
        return producto;
    }

}
