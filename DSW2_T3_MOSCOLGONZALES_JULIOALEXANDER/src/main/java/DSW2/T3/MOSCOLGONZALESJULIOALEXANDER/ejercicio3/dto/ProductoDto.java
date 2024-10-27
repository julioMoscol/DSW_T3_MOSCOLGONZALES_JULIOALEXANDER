package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Animal;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Estado;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Proveedor;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.TipoProducto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDto {

    private Integer idproducto;
    private TipoProducto tipoProducto;
    private Proveedor proveedor;
    private String nombre;
    private Integer cantidad;
    private Double preciopublico;
    private Integer stockminimo;
    private Integer stockmaximo;
    private Estado estado;
    private Animal animal;
    private Double precioproveedor;
}
