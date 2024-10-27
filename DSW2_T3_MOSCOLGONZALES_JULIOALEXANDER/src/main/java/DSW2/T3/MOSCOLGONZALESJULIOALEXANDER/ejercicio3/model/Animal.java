package DSW2.T3.MOSCOLGONZALESJULIOALEXANDER.ejercicio3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idanimal;
    private String descanimal;
}
