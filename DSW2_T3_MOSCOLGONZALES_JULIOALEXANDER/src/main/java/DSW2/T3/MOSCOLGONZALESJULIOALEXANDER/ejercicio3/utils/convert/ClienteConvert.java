package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.utils.convert;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ClienteDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteConvert {

    public ClienteDto convertirClienteAClienteDto(Cliente cliente){
        return ClienteDto.builder().nombres(cliente.getNombres()).
                apellidos(cliente.getApellidos()).
                dni(cliente.getDni()).
                telefono(cliente.getTelefono()).
                correo(cliente.getCorreo()).
                direccion(cliente.getDireccion())
                .build();
    }

    public Cliente convertirClienteDtoACliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setNombres(clienteDto.getNombres());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setDni(clienteDto.getDni());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCorreo(clienteDto.getCorreo());
        cliente.setDireccion(clienteDto.getDireccion());
        return cliente;
    }
}
