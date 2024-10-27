package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProveedorDto {

    private Integer idproveedor;
    private String telefono;
    private String direccion;
    private String empresa;
    private String ruc;
    private String correo;
    private String representante;
}
