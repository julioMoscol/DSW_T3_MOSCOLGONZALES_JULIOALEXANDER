package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproveedor;
    private String telefono;
    private String direccion;
    private String empresa;
    private String ruc;
    private String correo;
    private String representante;
}
