package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDto {

    private Integer idcliente;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private String correo;
    private String direccion;
}
