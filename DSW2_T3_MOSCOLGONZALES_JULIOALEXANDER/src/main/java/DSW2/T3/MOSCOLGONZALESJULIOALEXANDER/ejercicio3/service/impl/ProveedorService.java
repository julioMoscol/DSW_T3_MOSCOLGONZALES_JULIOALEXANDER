package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.impl;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ProveedorDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.exception.ResourceNotFoundException;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Proveedor;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.repository.ProveedorRepository;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProveedorService implements IProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Proveedor registrarProveedor(ProveedorDto proveedorDto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setTelefono(proveedorDto.getTelefono());
        proveedor.setDireccion(proveedorDto.getDireccion());
        proveedor.setEmpresa(proveedorDto.getEmpresa());
        proveedor.setRuc(proveedorDto.getRuc());
        proveedor.setCorreo(proveedorDto.getCorreo());
        proveedor.setRepresentante(proveedorDto.getRepresentante());
        return proveedorRepository.save(proveedor);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Proveedor buscarProveedorPorId(Integer idproveedor) {
        return proveedorRepository.findById(idproveedor)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con id: " + idproveedor));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Proveedor actualizarProveedor(Integer idproveedor, ProveedorDto proveedorDto) {
        Proveedor proveedorExistente = proveedorRepository.findById(idproveedor)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con id: " + idproveedor));

        proveedorExistente.setTelefono(proveedorDto.getTelefono());
        proveedorExistente.setDireccion(proveedorDto.getDireccion());
        proveedorExistente.setEmpresa(proveedorDto.getEmpresa());
        proveedorExistente.setRuc(proveedorDto.getRuc());
        proveedorExistente.setCorreo(proveedorDto.getCorreo());
        proveedorExistente.setRepresentante(proveedorDto.getRepresentante());

        return proveedorRepository.save(proveedorExistente);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void eliminarProveedor(Integer idproveedor) {
        Proveedor proveedorExistente = proveedorRepository.findById(idproveedor)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con id: " + idproveedor));
        proveedorRepository.delete(proveedorExistente);
    }
}
