package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;

    @ManyToOne
    @JoinColumn(name = "idtipopro")
    private TipoProducto tipoProducto;

    @ManyToOne
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;

    private String nombre;
    private Integer cantidad;
    private Double preciopublico;
    private Integer stockminimo;
    private Integer stockmaximo;

    @ManyToOne
    @JoinColumn(name = "codestado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idanimal")
    private Animal animal;

    private Double precioproveedor;
}
