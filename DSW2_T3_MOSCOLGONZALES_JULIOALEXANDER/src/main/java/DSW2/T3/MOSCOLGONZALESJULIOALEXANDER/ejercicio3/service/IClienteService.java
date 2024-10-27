package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ClienteDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente registrarCliente(ClienteDto clienteDto);
    List<Cliente> listarClientes();
    Cliente buscarClientePorId(Integer idcliente);
    Cliente actualizarCliente(Integer idcliente, ClienteDto clienteDto);
    void eliminarCliente(Integer idcliente);
}
