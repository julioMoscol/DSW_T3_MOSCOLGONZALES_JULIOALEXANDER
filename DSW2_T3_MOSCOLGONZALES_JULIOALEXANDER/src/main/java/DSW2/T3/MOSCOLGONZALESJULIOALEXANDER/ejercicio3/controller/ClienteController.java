package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.controller;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ClienteDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Cliente;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

    private final IClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> registrarCliente(@RequestBody ClienteDto clienteDto){
        return new ResponseEntity<>(clienteService.registrarCliente(clienteDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("id") Integer idcliente) {
        return new ResponseEntity<>(clienteService.buscarClientePorId(idcliente), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Integer idcliente, @RequestBody ClienteDto clienteDto) {
        return new ResponseEntity<>(clienteService.actualizarCliente(idcliente, clienteDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id") Integer idcliente) {
        clienteService.eliminarCliente(idcliente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
