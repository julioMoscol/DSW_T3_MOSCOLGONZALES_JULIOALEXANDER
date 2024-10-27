package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipoproducto")
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipopro;
    private String desctipopro;
}
