package fr.eni.votes.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Passion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPassion;
    @Getter
    private String nom;

    @ManyToMany
    @Getter
    private Set<Candidat> candidats = new HashSet<>();

    public Passion(String nom) {
        this.nom = nom;
    }

}
