package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.utils.convert;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ProveedorDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorConvert {

    public ProveedorDto convertirProveedorAProveedorDto(Proveedor proveedor){
        return ProveedorDto.builder().telefono(proveedor.getTelefono()).
                direccion(proveedor.getDireccion()).
                empresa(proveedor.getEmpresa()).
                ruc(proveedor.getRuc()).
                correo(proveedor.getCorreo()).
                representante(proveedor.getRepresentante())
                .build();
    }

    public Proveedor convertirProveedorDtoAProveedor(ProveedorDto proveedorDto){
        Proveedor proveedor = new Proveedor();
        proveedor.setTelefono(proveedorDto.getTelefono());
        proveedor.setDireccion(proveedorDto.getDireccion());
        proveedor.setEmpresa(proveedorDto.getEmpresa());
        proveedor.setRuc(proveedorDto.getRuc());
        proveedor.setCorreo(proveedorDto.getCorreo());
        proveedor.setRepresentante(proveedorDto.getRepresentante());
        return proveedor;
    }
}
