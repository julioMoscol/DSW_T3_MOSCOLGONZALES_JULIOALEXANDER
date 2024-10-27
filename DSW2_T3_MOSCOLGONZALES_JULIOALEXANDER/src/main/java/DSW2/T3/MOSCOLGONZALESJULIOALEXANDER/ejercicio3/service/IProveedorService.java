package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.service;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.dto.ProveedorDto;
import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Proveedor;

import java.util.List;

public interface IProveedorService {

    Proveedor registrarProveedor(ProveedorDto  proveedorDto);
    List <Proveedor> listarProveedores();
    Proveedor buscarProveedorPorId(Integer idproveedor);
    Proveedor actualizarProveedor(Integer idproveedor, ProveedorDto proveedorDto);
    void eliminarProveedor(Integer idproveedor);
}
