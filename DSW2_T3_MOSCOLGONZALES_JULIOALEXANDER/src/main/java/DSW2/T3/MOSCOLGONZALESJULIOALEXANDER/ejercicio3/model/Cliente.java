package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correo;
    private String direccion;
}
