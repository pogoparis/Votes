package fr.eni.votes.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Candidat {
    @Id
    @GeneratedValue
    private Integer idCandidat;
    private String nom;
    private String prenom;
    private int voteCount;

    @ManyToMany
    private Set<Passion> passions = new HashSet<>();

    public Candidat(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;

    }


}
