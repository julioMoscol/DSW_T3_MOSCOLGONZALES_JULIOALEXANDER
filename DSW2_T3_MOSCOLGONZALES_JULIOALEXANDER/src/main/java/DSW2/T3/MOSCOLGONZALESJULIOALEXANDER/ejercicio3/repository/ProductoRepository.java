package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.repository;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
