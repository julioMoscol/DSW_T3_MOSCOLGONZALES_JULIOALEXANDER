package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.repository;

import DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
