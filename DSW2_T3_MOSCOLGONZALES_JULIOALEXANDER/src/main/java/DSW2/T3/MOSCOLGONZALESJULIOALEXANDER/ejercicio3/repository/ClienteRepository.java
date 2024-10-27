package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.repository;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
