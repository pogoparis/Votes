package fr.eni.votes.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    public Candidat(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;

    }

}
