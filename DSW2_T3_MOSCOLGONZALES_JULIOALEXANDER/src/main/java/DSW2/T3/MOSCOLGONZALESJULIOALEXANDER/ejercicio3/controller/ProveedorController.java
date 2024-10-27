package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.controller;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ProveedorDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Proveedor;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/proveedor")
public class ProveedorController {

    private final IProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<Proveedor> registrarProveedor(@RequestBody ProveedorDto proveedorDto) {
        return new ResponseEntity<>(proveedorService.registrarProveedor(proveedorDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        return new ResponseEntity<>(proveedorService.listarProveedores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> buscarProveedorPorId(@PathVariable("id") Integer idproveedor) {
        return new ResponseEntity<>(proveedorService.buscarProveedorPorId(idproveedor), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable("id") Integer idproveedor, @RequestBody ProveedorDto proveedorDto) {
        return new ResponseEntity<>(proveedorService.actualizarProveedor(idproveedor, proveedorDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable("id") Integer idproveedor) {
        proveedorService.eliminarProveedor(idproveedor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
