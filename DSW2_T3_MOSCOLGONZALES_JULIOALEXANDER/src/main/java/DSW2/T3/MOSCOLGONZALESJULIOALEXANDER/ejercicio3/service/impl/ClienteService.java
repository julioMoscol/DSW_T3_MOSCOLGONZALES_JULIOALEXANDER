package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.impl;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ClienteDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.exception.ResourceNotFoundException;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Cliente;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.repository.ClienteRepository;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Cliente registrarCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setIdcliente(clienteDto.getIdcliente());
        cliente.setNombres(clienteDto.getNombres());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setDni(clienteDto.getDni());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCorreo(clienteDto.getCorreo());
        cliente.setDireccion(clienteDto.getDireccion());
        return clienteRepository.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente buscarClientePorId(Integer idcliente) {
        return clienteRepository.findById(idcliente)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + idcliente));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Cliente actualizarCliente(Integer idcliente, ClienteDto clienteDto) {
        Cliente clienteExistente = clienteRepository.findById(idcliente)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + idcliente));

        clienteExistente.setNombres(clienteDto.getNombres());
        clienteExistente.setApellidos(clienteDto.getApellidos());
        clienteExistente.setDni(clienteDto.getDni());
        clienteExistente.setTelefono(clienteDto.getTelefono());
        clienteExistente.setCorreo(clienteDto.getCorreo());
        clienteExistente.setDireccion(clienteDto.getDireccion());

        return clienteRepository.save(clienteExistente);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void eliminarCliente(Integer idcliente) {
        Cliente clienteExistente = clienteRepository.findById(idcliente)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + idcliente));
        clienteRepository.delete(clienteExistente);
    }
}
